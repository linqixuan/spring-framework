package com.lqx.java.config;

import com.lqx.java.config.dao.UserDao;
import com.lqx.java.config.dao.UserDaoImple2;
import com.lqx.java.config.factorybean.TestFactoryBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname AnnotationContextMain
 * @description TODO
 * @date 2022/5/18 8:05
 */
public class AnnotationContextMain {

	@Test
	public void beanDefinitionRegistryPostProcessorTest0() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
//		UserDaoImple userDaoImple = applicationContext.getBean(UserDaoImple.class);
		UserDao userDao = applicationContext.getBean(UserDao.class);
		userDao.getUser();
//		applicationContext.register(MyConfig.class);
//		applicationContext.addBeanFactoryPostProcessor(new TestBeanDefinitionRegistryPostProcessor());
//		applicationContext.refresh();
	}

	@Test
	public void factoryBeanTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(TestFactoryBean.class);
		applicationContext.refresh();
		// 获取testFactoryBean，获取的是TestFactoryBean的getObject()创建的实例
		Object obj = applicationContext.getBean("testFactoryBean");
		System.out.println(obj);
		// 获取&testFactoryBean，获取TestFactoryBean自身
		Object objFactory =  applicationContext.getBean("&testFactoryBean");
		System.out.println(objFactory);
	}

	@Test
	public void instanceSupplierTest0()  {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(MyConfig.class);
		applicationContext.registerBean("userDao",UserDao.class,() -> {
			System.out.println("UserDao自定义提供器");
			return new UserDaoImple2();
		},null);
		applicationContext.refresh();
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao);
		userDao = (UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao);
	}


}
