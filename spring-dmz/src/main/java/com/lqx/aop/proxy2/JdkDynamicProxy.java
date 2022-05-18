package com.lqx.aop.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linqx
 * @version 1.0
 * @classname JdkDynamicProxy
 * @description TODO
 * @date 2022/5/17 8:56
 */
public class JdkDynamicProxy implements InvocationHandler {

	Object target;

	public Object getProxy(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("======JDKDynamicProxy 调用之前=======");
		Object res = method.invoke(this.target, args);
		System.out.println("======JDKDynamicProxy 调用之后=======");
		return res;
	}
}
