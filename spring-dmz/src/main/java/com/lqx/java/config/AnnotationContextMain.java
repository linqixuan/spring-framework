package com.lqx.java.config;

import com.lqx.java.config.postprocessor.TestBeanDefinitionRegistryPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname AnnotationContextMain
 * @description TODO
 * @date 2022/5/18 8:05
 */
public class AnnotationContextMain {

	@Test
	public void beanDefinitionRegistryPostProcessorTest0() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(MyConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new TestBeanDefinitionRegistryPostProcessor());
		applicationContext.refresh();
	}

}
