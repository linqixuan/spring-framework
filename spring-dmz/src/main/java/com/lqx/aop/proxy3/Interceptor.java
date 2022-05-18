package com.lqx.aop.proxy3;

/**
 * The interface Interceptor.
 *
 * @author linqx
 * @version 1.0
 * @interfacename Interceptor
 * @description TODO
 * @date 2022 /5/17 9:05
 */
public interface Interceptor {
	/**
	 * Before.
	 */
	void before();

	/**
	 * After.
	 */
	void after();
}
