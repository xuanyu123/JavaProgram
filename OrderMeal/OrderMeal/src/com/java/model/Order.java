package com.java.model;

public class Order {
	
	private int id;  // 编号
	private String orderNum; // 订单编号
	private int totalAmount; // 总数量
	private Float totalMoney; // 总金额
	private int sale;         // 打折
	private Float realMoney;  // 实际支付金额
	private int cTypeId;        // 客户类型
	private String cashier;   // 收银员
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public Float getRealMoney() {
		return realMoney;
	}
	public void setRealMoney(Float realMoney) {
		this.realMoney = realMoney;
	}
	
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public int getcTypeId() {
		return cTypeId;
	}
	public void setcTypeId(int cTypeId) {
		this.cTypeId = cTypeId;
	}
}
