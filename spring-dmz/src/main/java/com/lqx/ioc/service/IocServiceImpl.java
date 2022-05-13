package com.lqx.ioc.service;

/**
 * @author linqx
 * @date 2022/5/12/0012 8:03
 */
//@Service
public class IocServiceImpl implements IocService {
	@Override
	public String hello() {
		System.out.println("hello, ioc");
		return "hello, ioc";
	}
}
