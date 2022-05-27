package com.lqx.beandefinitions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname BeanMain
 * @description TODO
 * @date 2022/5/27 10:49
 */
public class BeanMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MergeConfig.class);
	}
}
