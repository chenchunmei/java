package com.remarkable.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	
	//用户id
	private int u_id;
	//登陆手机号
	private String u_phone;
	//密码
	private String u_pwd;
	//昵称
	private String u_nickname;
	//性别
	private int u_sex;
	//出生年月日
	@DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
	@JSONField(format ="yyyy-MM-dd")
	private Date u_birthday;
	//状态
	private int  u_state;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public int getU_sex() {
		return u_sex;
	}
	public void setU_sex(int u_sex) {
		this.u_sex = u_sex;
	}
	public Date getU_birthday() {
		return u_birthday;
	}
	public void setU_birthday(Date u_birthday) {
		this.u_birthday = u_birthday;
	}
	public int getU_state() {
		return u_state;
	}
	public void setU_state(int u_state) {
		this.u_state = u_state;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_phone=" + u_phone + ", u_pwd=" + u_pwd + ", u_nickname=" + u_nickname
				+ ", u_sex=" + u_sex + ", u_birthday=" + u_birthday + ", u_state=" + u_state + "]";
	}
	
	
	
}
