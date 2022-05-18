package com.lqx.java.config.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author linqx
 * @version 1.0
 * @classname TestBeanDefinitionRegistryPostProcessorPriorityOrdered
 * @description TODO
 * @date 2022/5/18 10:05
 */
public class TestBeanDefinitionRegistryPostProcessorPriorityOrdered implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	public TestBeanDefinitionRegistryPostProcessorPriorityOrdered(){
		System.out.println("TestBeanDefinitionRegistryPostProcessorPriorityOrdered被创建了");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessorPriorityOrdered postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessorPriorityOrdered postProcessBeanFactory");
	}

	/** 排序的值，越小越前面 */
	@Override
	public int getOrder() {
		return 1;
	}
}
