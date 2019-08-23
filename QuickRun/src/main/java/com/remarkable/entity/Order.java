package com.remarkable.entity;

import java.util.Date;

public class Order {

	//订单id
	private int ord_id;
	//订单编号
	private String ord_code;
	//发布时间
	private Date ord_send_time;
	//取货码
	private String ord_pick_code;
	//联系电话
	private String ord_phone;
	//取件人姓名
	private String ord_rec_name;
	//包裹重量
	private int ord_wight;
	//备注
	private String ord_remark;
	//投诉订单
	private String ord_complaint;
	//订单状态
	private int ord_state;
	//接收时间id
	private int rec_id;
	//地址id
	private int add_id;
	//快递公司id
	private int com_id;
	//骑手id
	private int emp_id;
	//用户id
	private int u_id;
	
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public String getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(String ord_code) {
		this.ord_code = ord_code;
	}
	public Date getOrd_send_time() {
		return ord_send_time;
	}
	public void setOrd_send_time(Date ord_send_time) {
		this.ord_send_time = ord_send_time;
	}
	public String getOrd_pick_code() {
		return ord_pick_code;
	}
	public void setOrd_pick_code(String ord_pick_code) {
		this.ord_pick_code = ord_pick_code;
	}
	public String getOrd_phone() {
		return ord_phone;
	}
	public void setOrd_phone(String ord_phone) {
		this.ord_phone = ord_phone;
	}
	public String getOrd_rec_name() {
		return ord_rec_name;
	}
	public void setOrd_rec_name(String ord_rec_name) {
		this.ord_rec_name = ord_rec_name;
	}
	public int getOrd_wight() {
		return ord_wight;
	}
	public void setOrd_wight(int ord_wight) {
		this.ord_wight = ord_wight;
	}
	public String getOrd_remark() {
		return ord_remark;
	}
	public void setOrd_remark(String ord_remark) {
		this.ord_remark = ord_remark;
	}
	public String getOrd_complaint() {
		return ord_complaint;
	}
	public void setOrd_complaint(String ord_complaint) {
		this.ord_complaint = ord_complaint;
	}
	public int getOrd_state() {
		return ord_state;
	}
	public void setOrd_state(int ord_state) {
		this.ord_state = ord_state;
	}
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	
}
