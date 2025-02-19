/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io.support;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeHint;
import org.springframework.core.log.LogMessage;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

/**
 * {@link RuntimeHintsRegistrar} to register hints for {@code spring.factories}.
 *
 * @author Brian Clozel
 * @author Phillip Webb
 * @since 6.0
 * @see SpringFactoriesLoader
 */
class SpringFactoriesLoaderRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

	private static List<String> RESOURCE_LOCATIONS = List
			.of(SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION);

	private static final Consumer<TypeHint.Builder> HINT = builder -> builder
			.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

	private final Log logger = LogFactory.getLog(SpringFactoriesLoaderRuntimeHintsRegistrar.class);


	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
		for (String resourceLocation : RESOURCE_LOCATIONS) {
			registerHints(hints, classLoader, resourceLocation);
		}
	}

	private void registerHints(RuntimeHints hints, ClassLoader classLoader,
			String resourceLocation) {
		hints.resources().registerPattern(resourceLocation);
		Map<String, List<String>> factories = SpringFactoriesLoader
				.loadFactoriesResource(classLoader, resourceLocation);
		factories.forEach((factoryClassName, implementationClassNames) ->
				registerHints(hints, classLoader, factoryClassName, implementationClassNames));
	}

	private void registerHints(RuntimeHints hints, ClassLoader classLoader,
			String factoryClassName, List<String> implementationClassNames) {
		Class<?> factoryClass = resolveClassName(classLoader, factoryClassName);
		if(factoryClass == null) {
			logger.trace(LogMessage.format("Skipping factories for [%s]", factoryClassName));
			return;
		}
		logger.trace(LogMessage.format("Processing factories for [%s]", factoryClassName));
		hints.reflection().registerType(factoryClass, HINT);
		for (String implementationClassName : implementationClassNames) {
			Class<?> implementationType = resolveClassName(classLoader, implementationClassName);
			logger.trace(LogMessage.format("%s factory type [%s] and implementation [%s]",
					(implementationType != null) ? "Processing" : "Skipping", factoryClassName, implementationClassName));
			if (implementationType != null) {
				hints.reflection().registerType(implementationType, HINT);
			}
		}
	}

	@Nullable
	private Class<?> resolveClassName(ClassLoader classLoader, String factoryClassName) {
		try {
			return ClassUtils.resolveClassName(factoryClassName, classLoader);
		}
		catch (Exception ex) {
			return null;
		}
	}

}