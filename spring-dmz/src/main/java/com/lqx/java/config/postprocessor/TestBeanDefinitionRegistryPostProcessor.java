package com.lqx.java.config.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author linqx
 * @version 1.0
 * @classname TestBeanDefinitionRegistryPostProcessor
 * @description TODO
 * @date 2022/5/18 9:56
 */
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory");
		registry.registerBeanDefinition("mytest", new AnnotatedGenericBeanDefinition(TestBeanDefinitionRegistryPostProcessorPriorityOrdered.class));
	}
}
