package com.lqx.aop.proxy3;

/**
 * @author linqx
 * @version 1.0
 * @classname TimeInterceptor
 * @description TODO
 * @date 2022/5/17 9:24
 */
public class TimeInterceptor implements Interceptor {
	@Override
	public void before() {
		System.out.println("我是在方法前记录时间:");
	}

	@Override
	public void after() {
		System.out.println("我是在方法后记录时间");
	}
}
