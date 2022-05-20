package com.lqx.java.config.postprocessor;

import com.lqx.java.config.dao.UserDao;
import com.lqx.java.config.dao.UserDaoImple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linqx
 * @version 1.0
 * @classname TestJDKProxyInstantiationAwareBeanPostProcessor
 * @description TODO
 * @date 2022/5/19 16:36
 */
public class TestJDKProxyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if(beanName.equals("userDao")){
			UserDao userDaoimpl = new UserDaoImple();
			UserDao userDao = (UserDao) Proxy.newProxyInstance(getClass().getClassLoader(), userDaoimpl.getClass().getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("我是JDK动态代理的");
					return method.invoke(userDaoimpl);
				}
			});
			return userDao;
		}

		return null;
	}
}
