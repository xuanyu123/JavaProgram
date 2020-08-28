package com.java.dao;

import java.sql.SQLException;

import com.java.model.Meal;
import com.java.model.OrderMid;

public class OrderDao extends BaseDao{
	
	// 添加
	public boolean addOrderMid(OrderMid orderMid){
		String sql = "insert into o_ordermid values(null,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, orderMid.getOrderName());
			preparedStatement.setFloat(2, orderMid.getOrderPrice());
			preparedStatement.setInt(3, orderMid.getOrderAmount());
			preparedStatement.setInt(4, orderMid.getClassId());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
