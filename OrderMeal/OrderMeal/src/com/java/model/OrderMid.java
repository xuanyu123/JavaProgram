package com.java.model;

public class OrderMid {
	private int id;
	private String orderName;
	private Float orderPrice;
	private int orderAmount;
	private int classId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	
}
