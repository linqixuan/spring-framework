package com.lqx.java.config.factorybean;

import com.lqx.java.config.dao.UserDaoImple;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author linqx
 * @version 1.0
 * @classname TestFactoryBean
 * @description TODO
 * @date 2022/5/19 10:33
 */
@Component
public class TestFactoryBean implements FactoryBean<UserDaoImple> {
	@Override
	public UserDaoImple getObject() throws Exception {
		return new UserDaoImple();
	}

	@Override
	public Class<?> getObjectType() {
		return UserDaoImple.class;
	}
}
