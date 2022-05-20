package com.lqx.java.config;

import com.lqx.java.config.dao.UserDao;
import com.lqx.java.config.dao.UserDaoImple;
import com.lqx.java.config.postprocessor.TestJDKProxyInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linqx
 * @version 1.0
 * @classname MyConfig
 * @description TODO
 * @date 2022/5/18 8:04
 */
//@Import(MyImportBeanDefinitionRegistrar.class)
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
	public UserDao userDao() {
		return new UserDaoImple();
	}

	@Bean
	public TestJDKProxyInstantiationAwareBeanPostProcessor testJDKProxyInstantiationAwareBeanPostProcessor() {
		return new TestJDKProxyInstantiationAwareBeanPostProcessor();
	}

//	@Bean
//	public TestInstantiationAwareBeanPostProcessor testInstantiationAwareBeanPostProcessor() {
//		return new TestInstantiationAwareBeanPostProcessor();
//	}

//	@Bean
//	public static TestBeanDefinitionRegistryPostProcessorPriorityOrdered myRegistrar(){
//		return  new TestBeanDefinitionRegistryPostProcessorPriorityOrdered();
//	}

}
