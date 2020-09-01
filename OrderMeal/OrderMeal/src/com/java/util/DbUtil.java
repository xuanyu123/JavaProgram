package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/ordermeal?useUnicode=true&characterEncoding=utf-8"; //数据库连接地址
	private String dbUserName="数据用户名";  //数据库用户名
	private String dbPassword="数据库密码"; //数据库密码
	private String jdbcName="com.mysql.jdbc.Driver";  //驱动名称
	/**
	 * 建立数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getConn() {
		try {
			Class.forName(jdbcName);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 关闭数据库连接
	 * @return
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getConn();
			System.out.println("数据库连接成功！");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}

}
