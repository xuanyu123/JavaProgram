package com.java.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.java.util.DbUtil;

/**
 * 
 *@author Administrator
 *创建对数据库链接对象，整个项目与数据库交互都用这一个对象 
 * 
 */

public class BaseDao {
	public Connection con = new DbUtil().getConn();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
