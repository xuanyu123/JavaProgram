package com.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.model.MealClass;
import com.java.util.StringUtil;

/**
 * 菜品类别 
 */
public class ClassDao extends BaseDao{
	// 添加菜品类别
	public boolean addClass(MealClass mcl){
		String sql = "insert into o_class values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mcl.getName());
			preparedStatement.setString(2, mcl.getInfo());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// 查询菜品类别
	public List<MealClass> getClassList(MealClass mealClass){
		List<MealClass> retList = new ArrayList<MealClass>();
		String sqlString = "select * from o_class";
		if(!StringUtil.isEmpty(mealClass.getName())){
			sqlString += " where name like '%"+mealClass.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				MealClass mc = new MealClass();
				mc.setId(executeQuery.getInt("id"));
				mc.setName(executeQuery.getString("name"));
				mc.setInfo(executeQuery.getString("info"));
				retList.add(mc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	// 删除菜品类别
	public boolean delete(int id){
		String sql = "delete from o_class where id=?";
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
	
	// 更新菜品类别
	public boolean update(MealClass mc){
		String sql = "update o_class set name=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mc.getName());
			preparedStatement.setString(2, mc.getInfo());
			preparedStatement.setInt(3, mc.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}