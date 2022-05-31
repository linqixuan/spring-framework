package com.lqx.transaction;

import com.lqx.transaction.config.TransactionConfig;
import com.lqx.transaction.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @version 1.0
 * @classname TransactionMain
 * @description TODO
 * @date 2022/5/31 9:12
 */
public class TransactionMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
		UserDao userDao = applicationContext.getBean(UserDao.class);
		userDao.test();
	}
}
