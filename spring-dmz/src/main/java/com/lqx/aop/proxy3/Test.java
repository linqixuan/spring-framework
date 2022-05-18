package com.lqx.aop.proxy3;

import com.lqx.aop.service.MyServiceImpl;
import com.lqx.aop.service.MyServiceInterface;

/**
 * @author linqx
 * @version 1.0
 * @classname Test
 * @description TODO
 * @date 2022/5/17 10:04
 */
public class Test {

	public static void main(String[] args) {
		MyServiceInterface serviceInterface = new MyServiceImpl();
		JdkDynamicProxyAdvanced jdkDynamicProxyAdvanced = new JdkDynamicProxyAdvanced();
		MyServiceInterface proxy = (MyServiceInterface) jdkDynamicProxyAdvanced.getProxy(serviceInterface, new TimeInterceptor());
		proxy.doService();
		jdkDynamicProxyAdvanced.setInterceptor(new LogInterceptor());
		proxy.doService();
	}

}
