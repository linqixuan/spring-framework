package com.lqx.aop.config;

import com.lqx.aop.config.component.IService;
import com.lqx.aop.config.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname AopMain
 * @description TODO
 * @date 2022/5/20 10:43
 */
public class AopMain {

	@Test
	public void AopTest()  {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(MyConfig.class);
		applicationContext.refresh();
		IService bean = applicationContext.getBean(IService.class);
		bean.show();
	}

}
