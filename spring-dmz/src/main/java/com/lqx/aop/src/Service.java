package com.lqx.aop.src;

/**
 * @author linqx
 * @version 1.0
 * @classname Service
 * @description TODO
 * @date 2022/5/17 10:15
 */
public class Service {

	public Service(){
		System.out.println("=======Service=======");
	}

	public int doService(int i) {
		int result=5/i;
		System.out.println("运行doService");
		return result;
	}

}
