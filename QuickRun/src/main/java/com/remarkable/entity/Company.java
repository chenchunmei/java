package com.remarkable.entity;

public class Company {

	//公司id
	private int com_id;
	//公司名称
	private String com_name;
	//状态
	private int add_state;
	
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public int getAdd_state() {
		return add_state;
	}
	public void setAdd_state(int add_state) {
		this.add_state = add_state;
	}
	
}
