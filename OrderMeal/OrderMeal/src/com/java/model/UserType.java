package com.java.model;

public enum UserType {
	ADMIN("系统管理员",0),ORDCUSTOMER("普通客户",1),VIPCUSTOMER("VIP客户",2),EMPLOYEE("员工",3);
	private String name;
	private int index;
	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
