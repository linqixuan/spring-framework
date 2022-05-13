package com.lqx.jdbc.service;

/**
 * @author linqx
 * @date 2022/5/13/0013 14:35
 */
public interface JdbcService {

	void queryById(Integer id);

	void updateNameById(Integer id, String name);

	void testTransactional();

}
