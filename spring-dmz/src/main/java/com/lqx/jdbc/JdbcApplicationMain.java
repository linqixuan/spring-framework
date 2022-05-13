package com.lqx.jdbc;

import com.lqx.jdbc.config.JdbcConfig;
import com.lqx.jdbc.service.JdbcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linqx
 * @date 2022/5/13/0013 14:46
 */
public class JdbcApplicationMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		JdbcService jdbcService = context.getBean(JdbcService.class);
		jdbcService.updateNameById(1, "linqixuan");
		jdbcService.testTransactional();
		jdbcService.queryById(1);
	}

}
