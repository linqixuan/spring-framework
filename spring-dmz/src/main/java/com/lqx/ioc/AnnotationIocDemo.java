package com.lqx.ioc;

import com.lqx.ioc.service.IocService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @date 2022/5/12/0012 15:34
 */
public class AnnotationIocDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.lqx.ioc");
		IocService iocService=context.getBean(IocService.class);
		String hello = iocService.hello();
//		System.out.println(hello);
	}

}
