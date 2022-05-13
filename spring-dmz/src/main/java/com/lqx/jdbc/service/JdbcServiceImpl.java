package com.lqx.jdbc.service;

import com.lqx.jdbc.entity.User;
import com.lqx.jdbc.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linqx
 * @date 2022/5/13/0013 14:36
 */
public class JdbcServiceImpl implements JdbcService {

	private JdbcTemplate jdbcTemplate;

	public JdbcServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void queryById(Integer id) {
		List<User> list = jdbcTemplate.query("select id,name,age from user where id=?", new Object[]{id}, new UserRowMapper());
		if (list.size() > 0) {
			System.out.println("id 为" + id + "的用户名为：" + list.get(0).getName());
		}
	}

	@Override
	public void updateNameById(Integer id, String name) {
		jdbcTemplate.update("update user set name=? where id=?", new Object[]{name, id});
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void testTransactional() {
		jdbcTemplate.update("update user set name='王五' where id=1", new Object[]{});
		throw new RuntimeException("异常");
	}
}
