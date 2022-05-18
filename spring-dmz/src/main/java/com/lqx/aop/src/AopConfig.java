package com.lqx.aop.src;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author linqx
 * @version 1.0
 * @classname AopConfig
 * @description TODO
 * @date 2022/5/17 10:13
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lqx.aop.src")
public class AopConfig {

	@Bean
	public Service getService(){
		return new Service();
	}

	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}

}
