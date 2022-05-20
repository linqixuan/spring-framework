package com.lqx.aop.config.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author linqx
 * @version 1.0
 * @classname MyLogAspects
 * @description TODO
 * @date 2022/5/20 10:41
 */
@Aspect
@Component
public class MyLogAspects {

	/**
	 * 修饰符 返回类型(一定要有) 包名.类名.方法名(一定要有) 参数
	 */
	@Pointcut("execution(* com.lqx.aop.config.component.*.*(..))")
	public void pointCut() {
	}

	/**
	 * 在目标方法执行后
	 */
	@Before("pointCut()")
	public void logBefore() {
		System.out.println("logBefore");
	}

}
