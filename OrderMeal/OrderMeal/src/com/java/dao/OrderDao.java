package com.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.java.model.CustomerType;
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.model.Order;
import com.java.model.OrderMid;
import com.java.util.StringUtil;

public class OrderDao extends BaseDao{
	
	// 添加到OrderMid/OrderMidCopy表中
	public boolean addOrderMid(OrderMid orderMid){
		String sql = "insert into o_ordermid values(null,?,?,?,?,?,?)";
		String sql2 = "insert into o_ordermid_copy values(null,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			java.sql.PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
			preparedStatement.setString(1, orderMid.getOrderName());
			preparedStatement.setFloat(2, orderMid.getOrderPrice());
			preparedStatement.setInt(3, orderMid.getOrderAmount());
			preparedStatement.setInt(4, orderMid.getClassId());
			preparedStatement.setFloat(5, orderMid.getTotalMoney());
			preparedStatement.setString(6, "");
			preparedStatement2.setString(1, orderMid.getOrderName());
			preparedStatement2.setFloat(2, orderMid.getOrderPrice());
			preparedStatement2.setInt(3, orderMid.getOrderAmount());
			preparedStatement2.setInt(4, orderMid.getClassId());
			preparedStatement2.setFloat(5, orderMid.getTotalMoney());
			preparedStatement2.setString(6, "");
			if((preparedStatement.executeUpdate() > 0) && (preparedStatement2.executeUpdate() > 0))return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	

	// 查询订单列表数据
	public List<OrderMid> getMealOrderList(OrderMid orderMid){
		List<OrderMid> retList = new ArrayList<OrderMid>();
		String sqlString = "select * from o_ordermid";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				// 给字段赋值
				OrderMid o = new OrderMid();
				o.setId(executeQuery.getInt("id"));
				o.setOrderName(executeQuery.getString("orderName"));
				o.setOrderPrice(executeQuery.getFloat("orderPrice"));
				o.setOrderAmount(executeQuery.getInt("orderAmount"));
				o.setClassId(executeQuery.getInt("classId"));
				o.setTotalMoney(executeQuery.getFloat("totalMoney"));
				o.setOrderNum(executeQuery.getString("orderNum"));
				retList.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	// 计算数量
	public Integer getSumAmount() {
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		String sql = "select sum(orderAmount) from o_ordermid";
		try {
			preparedStatement = con.prepareStatement(sql);
			executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				return executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	// 计算总金额
	public Integer getTotalMoney() {
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		String sql = "select sum(totalMoney) from o_ordermid";
		try {
			preparedStatement = con.prepareStatement(sql);
			executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				return executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// 删除
	public boolean delete(int id) {
		String sql = "delete from o_ordermid where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 查询客户类型
	public List<CustomerType> getCustomerType(CustomerType customerType){
		List<CustomerType> customerList = new ArrayList<CustomerType>();
		String sqlString = "select * from o_customertype";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				CustomerType ct = new CustomerType();
				ct.setId(executeQuery.getInt("id"));
				ct.setName(executeQuery.getString("name"));
				customerList.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}
	
	// 将订单编号更新到orderMid表中
	public boolean updateOrderNum(String orderNum, Integer id){
		String sql = "update o_ordermid_copy set orderNum=? WHERE id=?";
		String sql2 = "update o_ordermid set orderNum=? WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, orderNum);
			preparedStatement.setInt(2, id);
			PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
			preparedStatement2.setString(1, orderNum);
			preparedStatement2.setInt(2, id);
			if((preparedStatement.executeUpdate() > 0) && (preparedStatement2.executeUpdate() > 0)){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 将订单信息插入到Order表中
	public boolean insertOrderInfo(Order order){
		String sql = "insert into o_order values(null,?,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, order.getOrderNum());
			preparedStatement.setInt(2, order.getTotalAmount());
			preparedStatement.setFloat(3, order.getTotalMoney());
			preparedStatement.setInt(4, order.getSale());
			preparedStatement.setFloat(5, order.getRealMoney());
			preparedStatement.setInt(6, order.getcTypeId());
			preparedStatement.setString(7, order.getCashier());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 清除OrderMid表中的该次订单数据
	public boolean deleteOrderMid() {
		String sql = "delete from o_ordermid";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			if(!(preparedStatement.executeUpdate() > 0)){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 将订单信息显示到订单成功页面
	public List<Order> getOrderList(String orderNum){
		List<Order> successList = new ArrayList<Order>();
		String sqlString = "select * from o_order where orderNum = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			preparedStatement.setString(1, orderNum);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				// 给字段赋值
				Order order = new Order();
				order.setId(executeQuery.getInt("id"));
				order.setcTypeId(executeQuery.getInt("cTypeId"));
				order.setTotalMoney(executeQuery.getFloat("totalMoney"));
				order.setRealMoney(executeQuery.getFloat("realMoney"));
				order.setCashier(executeQuery.getString("cashier"));
				order.setTotalAmount(executeQuery.getInt("totalAmount"));
				successList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successList;
	}
	
	
	// 计算客户类型销售额度
	public List getCustomerSale() {
		PreparedStatement preparedStatement = null;
		ResultSet executeQuery = null;
		String sql = "select cTypeId, sum(realMoney) from o_order as oo GROUP BY cTypeId";
		try {
			preparedStatement = con.prepareStatement(sql);
			executeQuery = preparedStatement.executeQuery();
			Float sale = null;
			List list = new ArrayList();
			while(executeQuery.next()) {
				sale = executeQuery.getFloat(2);
				list.add(sale);
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
