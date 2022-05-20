package com.lqx.java.config.postprocessor;

import com.lqx.java.config.dao.UserDao;
import com.lqx.java.config.dao.UserDaoImple2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author linqx
 * @version 1.0
 * @classname InstanceSupplierBeanDefinitionRegistryPostProcessor
 * @description TODO
 * @date 2022/5/19 19:41
 */
public class InstanceSupplierBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		registry.registerBeanDefinition("userDao",new RootBeanDefinition(UserDao.class, () -> {
			System.out.println("UserDao自定义提供器");
			return new UserDaoImple2();
		}));
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
