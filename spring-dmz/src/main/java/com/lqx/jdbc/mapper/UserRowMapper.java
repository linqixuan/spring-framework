package com.lqx.jdbc.mapper;

import com.lqx.jdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author linqx
 * @date 2022/5/13/0013 11:22
 */
public class UserRowMapper implements RowMapper<User>, Serializable {

	private static final long serialVersionUID = 10L;

	@Override
	@Nullable
	public User mapRow(ResultSet resultSet, int i) throws SQLException {
		User user=new User();
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setAge(resultSet.getInt("age"));
		return user;
	}
}
