package com.lqx.aop.proxy1;

import com.lqx.aop.service.MyServiceInterface;

/**
 * @author linqx
 * @version 1.0
 * @classname AopProxy1
 * @description TODO
 * @date 2022/5/17 8:40
 */
public class AopProxy1 implements MyServiceInterface {

	MyServiceInterface myServiceInterface;

	public void setMyServiceInterface(MyServiceInterface myServiceInterface) {
		this.myServiceInterface = myServiceInterface;
	}

	@Override
	public void doService() {
		System.out.println("======doService之前=======");
		myServiceInterface.doService();
		System.out.println("======doService之后=======");
	}
}
