package com.remarkable.entity;

public class Company {

	//公司id
	private int com_id;
	//公司名称
	private String com_name;
	//状态
	private int com_state;
	//内容
	private String com_content;
	
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
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
	public int getCom_state() {
		return com_state;
	}
	public void setCom_state(int com_state) {
		this.com_state = com_state;
	}
	
}
