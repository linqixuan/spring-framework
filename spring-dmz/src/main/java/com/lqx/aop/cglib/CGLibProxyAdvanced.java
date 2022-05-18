package com.lqx.aop.cglib;

import com.lqx.aop.service.MyServiceImpl;
import com.lqx.aop.service.MyServiceInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author linqx
 * @version 1.0
 * @classname CGLibProxyAdvanced
 * @description TODO
 * @date 2022/5/17 10:10
 */
public class CGLibProxyAdvanced {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MyServiceImpl.class);
		enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
			System.out.println("cglib 代理");
			methodProxy.invokeSuper(o,objects);
			return o;
		});
		MyServiceInterface serviceInterface = (MyServiceInterface) enhancer.create();
		serviceInterface.doService();
	}

}
