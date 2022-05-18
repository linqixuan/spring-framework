package com.lqx.java.config.registrar;

import com.lqx.java.config.entity.TestBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linqx
 * @version 1.0
 * @classname MyImportBeanDefinitionRegistrar
 * @description TODO
 * @date 2022/5/18 16:45
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotatedBeanDefinition genericBeanDefinition = new AnnotatedGenericBeanDefinition(TestBean.class);
		registry.registerBeanDefinition("testBean", genericBeanDefinition);
	}
}
