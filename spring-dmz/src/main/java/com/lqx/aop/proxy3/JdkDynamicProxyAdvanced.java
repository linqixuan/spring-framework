package com.lqx.aop.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linqx
 * @version 1.0
 * @classname JdkDynamicProxyAdvanced
 * @description TODO
 * @date 2022/5/17 9:25
 */
public class JdkDynamicProxyAdvanced implements InvocationHandler {

	Object target;

	Interceptor interceptor;

	public void setInterceptor(Interceptor interceptor) {
		this.interceptor = interceptor;
	}

	public Object getProxy(Object target, Interceptor interceptor) {
		this.interceptor=interceptor;
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		interceptor.before();
		Object res = method.invoke(this.target, args);
		interceptor.after();
		return res;
	}
}
