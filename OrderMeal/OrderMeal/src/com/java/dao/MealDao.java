package com.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Meal;
import com.java.util.StringUtil;

public class MealDao extends BaseDao{
	
	// 添加
	public boolean addMeal(Meal meal){
		String sql = "insert into o_meal values(null,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, meal.getMealName());
			preparedStatement.setInt(2, meal.getClassId());
			preparedStatement.setFloat(3, meal.getPrice());
			preparedStatement.setString(4, meal.getMealInfo());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 查询
	public List<Meal> getMealList(Meal meal){
		List<Meal> retList = new ArrayList<Meal>();
		StringBuffer sqlString = new StringBuffer("select * from o_meal");
		if(!StringUtil.isEmpty(meal.getMealName())){
			sqlString.append(" and mealName like '%"+meal.getMealName()+"%'");
		}
		if(meal.getClassId() != 0){
			sqlString.append(" and classId ="+meal.getClassId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Meal m = new Meal();
				m.setId(executeQuery.getInt("id"));
				m.setMealName(executeQuery.getString("mealName"));
				m.setClassId(executeQuery.getInt("classId"));
				m.setPrice(executeQuery.getFloat("price"));
				m.setMealInfo(executeQuery.getString("mealInfo"));
				retList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	// 更新
	public boolean update(Meal meal){
		String sql = "update o_meal set mealName=?, classId=?, price=?, mealInfo=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, meal.getMealName());
			preparedStatement.setInt(2, meal.getClassId());
			preparedStatement.setFloat(3, meal.getPrice());
			preparedStatement.setString(4, meal.getMealInfo());
			preparedStatement.setInt(5, meal.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 删除选中数据
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from o_meal where id=?";
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
}
