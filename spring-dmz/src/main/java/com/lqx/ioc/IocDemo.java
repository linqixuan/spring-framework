package com.lqx.ioc;

import com.lqx.ioc.service.IocService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author linqx
 * @date 2022/5/11/0011 9:17
 */
public class IocDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-ioc.xml");
		IocService iocService = context.getBean(IocService.class);
		System.out.println(iocService.hello());
	}

}
