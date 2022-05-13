package com.lqx.ioc.config;

import com.lqx.ioc.service.IocServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author linqx
 * @date 2022/5/12/0012 15:33
 */
@EnableAspectJAutoProxy
@Configuration
@Import(IocServiceImpl.class)
public class AnnotationConfig {

//	@Bean
//	public IocService iocService() {
//		return new IocServiceImpl();
//	}

}
