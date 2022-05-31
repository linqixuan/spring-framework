package com.lqx.transaction.dao;

import com.lqx.transaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author linqx
 * @version 1.0
 * @classname UserDaoImpl
 * @description TODO
 * @date 2022/5/31 9:05
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountDao accountDao;

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	@Override
	public void test() {
		User user = new User();
		user.setUsername("n1");
		user.setPassword("p1");
		jdbcTemplate.update("insert into user (username, password) value(?, ?)",
				new Object[]{user.getUsername(), user.getPassword()});
		accountDao.insertTest1();
	}
}
