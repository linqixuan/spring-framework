package com.lqx.aop.service;

import com.lqx.aop.service.MyServiceImpl;
import com.lqx.aop.service.MyServiceInterface;

/**
 * @author linqx
 * @version 1.0
 * @classname Test
 * @description TODO
 * @date 2022/5/17 8:28
 **/
public class Test {
	public static void main(String[] args) {
		MyServiceInterface myService=new MyServiceImpl();
		myService.doService();
	}
}

