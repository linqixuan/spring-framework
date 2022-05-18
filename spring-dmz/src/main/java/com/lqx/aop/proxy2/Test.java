package com.lqx.aop.proxy2;

import com.lqx.aop.service.MyServiceImpl;
import com.lqx.aop.service.MyServiceInterface;

/**
 * @author linqx
 * @version 1.0
 * @classname Test
 * @description TODO
 * @date 2022/5/17 8:59
 */
public class Test {

	public static void main(String[] args) {
		MyServiceInterface serviceInterface = new MyServiceImpl();
		JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy();
		MyServiceInterface proxy = (MyServiceInterface) jdkDynamicProxy.getProxy(serviceInterface);
		proxy.doService();
	}

}
