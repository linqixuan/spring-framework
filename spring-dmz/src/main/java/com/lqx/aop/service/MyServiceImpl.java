package com.lqx.aop.service;

/**
 * @author linqx
 * @version 1.0
 * @classname MyServiceImpl
 * @description TODO
 * @date 2022/5/17 8:39
 */
public class MyServiceImpl implements MyServiceInterface {
	@Override
	public void doService() {
		System.out.println("========doService========");
	}
}
