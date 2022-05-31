package com.lqx.transaction.dao;

import com.lqx.transaction.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author linqx
 * @version 1.0
 * @classname AccountDaoImpl
 * @description TODO
 * @date 2022/5/31 9:05
 */
public class AccountDaoImpl implements AccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void insertTest1() {
		Account account = new Account();
		account.setMoney(100);
		jdbcTemplate.update("insert into account (money) value(?)", new Object[]{account.getMoney()});
//		System.out.println(1 / 0);
	}

}
