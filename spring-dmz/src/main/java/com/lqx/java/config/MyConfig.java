package com.lqx.java.config;

import com.lqx.java.config.postprocessor.TestBeanDefinitionRegistryPostProcessorPriorityOrdered;
import com.lqx.java.config.registrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author linqx
 * @version 1.0
 * @classname MyConfig
 * @description TODO
 * @date 2022/5/18 8:04
 */
@Import(MyImportBeanDefinitionRegistrar.class)
@Configuration
public class MyConfig {

//	@Import(T2.class)
//	class T1 {
//
//	}
//
//	@Import(T1.class)
//	class T2 {
//
//	}

	@Bean
	public static TestBeanDefinitionRegistryPostProcessorPriorityOrdered myRegistrar(){
		return  new TestBeanDefinitionRegistryPostProcessorPriorityOrdered();
	}

}
