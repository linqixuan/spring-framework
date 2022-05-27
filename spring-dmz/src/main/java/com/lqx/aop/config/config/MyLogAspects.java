package com.lqx.aop.config.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The type My log aspects.
 *
 * @author linqx
 * @version 1.0
 * @classname MyLogAspects
 * @description TODO
 * @date 2022 /5/20 10:41
 */
@Aspect
public class MyLogAspects {

	/**
	 * Instantiates a new My log aspects.
	 */
	public MyLogAspects() {
		System.out.println("======LogAspects========");
	}

	/**
	 * 修饰符 返回类型(一定要有) 包名.类名.方法名(一定要有) 参数
	 */
	@Pointcut("execution(* com.lqx.aop.config.component.*.*(..))")
	public void pointCut() {
	}

	/**
	 * 在目标方法执行前
	 *
	 * @param joinPoint the join point
	 */
	@Before("pointCut()")
	public void logBefore(JoinPoint joinPoint) {
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

	/**
	 * Log around object.
	 *
	 * @param joinPoint the join point
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("pointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logAround  开始运行:" + joinPoint.getSignature().getName());
		Object o = joinPoint.proceed();
		System.out.println("logAround  结束运行:" + joinPoint.getSignature().getName());
		return o;
	}

}
