package com.lqx.aop.src;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The type Log aspects.
 *
 * @author linqx
 * @version 1.0
 * @classname LogAspects
 * @description TODO
 * @date 2022 /5/17 10:16
 */
@Aspect
public class LogAspects {

	/**
	 * Instantiates a new Log aspects.
	 */
	public LogAspects() {
		System.out.println("======LogAspects========");
	}

	/**
	 * Point cut.
	 */
	@Pointcut("execution(* com.lqx.aop.src.Service.*(..))")
	public void pointCut() {
	}

	/**
	 * 在目标方法执行前
	 *
	 * @param joinPoint the join point
	 */
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println("logStart  开始运行:" + joinPoint.getSignature().getName());
	}

	/**
	 * 在目标方法执行后
	 */
	@After("pointCut()")
	public void logAfter() {
		System.out.println("logAfter  结束运行");
	}

	/**
	 * 方法返回后
	 *
	 * @param result the result
	 */
	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturning(Object result) {
		System.out.println("logReturning  正常返回，结果:" + result);
	}

	/**
	 * 出现异常后
	 *
	 * @param exception the exception
	 */
	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(Exception exception) {
		System.out.println("logStarException  运行异常:" + exception);
	}

}
