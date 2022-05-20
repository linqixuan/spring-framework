package com.lqx.java.config.postprocessor;

import com.lqx.java.config.entity.TestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author linqx
 * @version 1.0
 * @classname TestInstantiationAwareBeanPostProcessor
 * @description TODO
 * @date 2022/5/19 16:27
 */
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (beanName.equals("userDaoImple")) {
			TestBean testBean = new TestBean();
			return testBean;
		}
		return null;
	}
}
