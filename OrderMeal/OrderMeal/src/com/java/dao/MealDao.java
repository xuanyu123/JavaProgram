package com.java.dao;

import java.sql.SQLException;

import com.java.model.Meal;

public class MealDao extends BaseDao{
	public boolean addStudent(Meal meal){
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
}
