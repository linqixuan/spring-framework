package com.lqx.aop.config.component;

/**
 * @author linqx
 * @version 1.0
 * @classname MyService
 * @description TODO
 * @date 2022/5/20 10:42
 */
public class MyService implements IService {

	@Override
	public void show() {
		System.out.println("MyService show");
	}

}
