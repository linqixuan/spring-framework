package com.lqx.aop.proxy1;

import com.lqx.aop.service.MyServiceImpl;
import com.lqx.aop.service.MyServiceInterface;

/**
 * @author linqx
 * @version 1.0
 * @classname Test
 * @description TODO
 * @date 2022/5/17 8:41
 */
public class Test {
	public static void main(String[] args) {
		MyServiceInterface myService = new MyServiceImpl();
		AopProxy1 aopProxy1=new AopProxy1();
		aopProxy1.setMyServiceInterface(myService);
		aopProxy1.doService();
	}
}