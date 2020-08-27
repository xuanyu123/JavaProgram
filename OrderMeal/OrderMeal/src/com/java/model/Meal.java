package com.java.model;

public class Meal {
	private int id;   // 菜品编号
	private String mealName;  // 菜品名称
	private int classId;      // 类别编号
	private float price;        // 菜品价格
	private String mealInfo;  // 菜品描述
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMealInfo() {
		return mealInfo;
	}
	public void setMealInfo(String mealInfo) {
		this.mealInfo = mealInfo;
	}
}
