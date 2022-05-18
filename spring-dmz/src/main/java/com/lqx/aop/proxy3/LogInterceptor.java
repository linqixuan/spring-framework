package com.lqx.aop.proxy3;

/**
 * @author linqx
 * @version 1.0
 * @classname LogInterceptor
 * @description TODO
 * @date 2022/5/17 9:06
 */
public class LogInterceptor implements Interceptor{
	@Override
	public void before() {
		System.out.println("我只是在方法前打log");
	}

	@Override
	public void after() {
		System.out.println("我只是在方法后打log");
	}
}
