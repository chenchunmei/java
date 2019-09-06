package com.remarkable.entity;

public class Address {

	//地址id
	private int add_id;
	//详细地址
	private String add_detail;
	//地址状态
	private int add_state;
	//负责棋手id
	private int emp_id;
	//负责骑手
	private String emp_name;
	private Emp emp;
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getAdd_detail() {
		return add_detail;
	}
	public void setAdd_detail(String add_detail) {
		this.add_detail = add_detail;
	}
	public int getAdd_state() {
		return add_state;
	}
	public void setAdd_state(int add_state) {
		this.add_state = add_state;
	}
	
}
