package com.remarkable.entity;

public class Emp {

	//骑手id
	private int emp_id;
	//姓名
	private String emp_name;
	//专业
	private String emp_major;
	//宿舍
	private String emp_dormitory;
	//学号
	private String emp_sno;
	//学号
	private String emp_pwd;
	//信誉分
	private int  emp_credit;
	//联系电话
	private String emp_phone;
	//状态
	private int  emp_state;
	
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_major() {
		return emp_major;
	}
	public void setEmp_major(String emp_major) {
		this.emp_major = emp_major;
	}
	public String getEmp_dormitory() {
		return emp_dormitory;
	}
	public void setEmp_dormitory(String emp_dormitory) {
		this.emp_dormitory = emp_dormitory;
	}
	public String getEmp_sno() {
		return emp_sno;
	}
	public void setEmp_sno(String emp_sno) {
		this.emp_sno = emp_sno;
	}
	public int getEmp_credit() {
		return emp_credit;
	}
	public void setEmp_credit(int emp_credit) {
		this.emp_credit = emp_credit;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public int getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(int emp_state) {
		this.emp_state = emp_state;
	}
	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_major=" + emp_major + ", emp_dormitory="
				+ emp_dormitory + ", emp_sno=" + emp_sno + ", emp_credit=" + emp_credit + ", emp_phone=" + emp_phone
				+ ", emp_state=" + emp_state + "]";
	}
	
	
	
}
