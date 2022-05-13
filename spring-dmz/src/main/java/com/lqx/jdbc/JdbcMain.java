package com.lqx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author linqx
 * @date 2022/5/13/0013 11:12
 */
public class JdbcMain {

	static final String URL = "jdbc:mysql://localhost:3306/spring?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true";
	static final String USER = "root";
	static final String PASSWORD = "123456";


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动程序
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. 获得数据库连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//3.操作数据库
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from t_gps_location");
		//4.处理返回值
		while(rs.next()){
			System.out.println("gps_sn:"+rs.getString("gps_sn"));
		}
	}
}
