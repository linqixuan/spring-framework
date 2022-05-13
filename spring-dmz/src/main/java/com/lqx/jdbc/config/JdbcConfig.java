package com.lqx.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lqx.jdbc.service.JdbcService;
import com.lqx.jdbc.service.JdbcServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author linqx
 * @date 2022/5/13/0013 14:43
 */
@Configuration
@EnableTransactionManagement
public class JdbcConfig {
	@Bean
	public DruidDataSource druidDataSource(){
		DruidDataSource druidDataSource=new DruidDataSource();
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("123456");
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring?characterEncoding=utf-8&useSSL=false");
		return druidDataSource;
	}
	@Bean
	public JdbcService jdbcService(DruidDataSource druidDataSource){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(druidDataSource);
		JdbcService jdbcService=new JdbcServiceImpl(jdbcTemplate);
		return jdbcService;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource) {
		return new DataSourceTransactionManager(druidDataSource);
	}
}
