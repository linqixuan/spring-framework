package com.lqx.aop.src;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname AopTest
 * @description TODO
 * @date 2022/5/17 10:18
 */
public class AopTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		Service service = applicationContext.getBean(Service.class);
		System.out.println(service.doService(1));

	}

}
