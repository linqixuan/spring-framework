package com.lqx.ioc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author linqx
 * @date 2022/5/12/0012 16:17
 */
@Aspect
@Component
public class AspectJAop {

//	@Pointcut("execution(public * com.lqx.ioc.service.IocService.hello(..))")
	@Pointcut("execution(public * com.lqx.ioc..*.*(..))")
	public void testAOP(){}

	@Before("testAOP()")
	public void before(){
		System.out.println("AspectJAop before testAOP...");
	}

	@After("testAOP()")
	public void after(){
		System.out.println("AspectJAop after testAOP...");
	}

	@Around("testAOP()")
	public Object around(ProceedingJoinPoint p){
		System.out.println("AspectJAo paround before testAOP...");
		Object o = null;
		try {
			o = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("AspectJA oparound after testAOP...");
		return o;
	}

}
