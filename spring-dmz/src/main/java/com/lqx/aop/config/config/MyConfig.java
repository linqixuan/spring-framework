package com.lqx.aop.config.config;

import com.lqx.aop.config.component.IService;
import com.lqx.aop.config.component.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author linqx
 * @version 1.0
 * @classname MyConfig
 * @description TODO
 * @date 2022/5/20 10:42
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfig {

	@Bean
	public IService getService() {
		return new MyService();
	}

	@Bean
	public MyLogAspects getMyLogAspects() {
		return new MyLogAspects();
	}
}
