package com.remarkable.entity;

public class AjaxResult {
	
	public void reset(){
		msg=null;
		data=null;
		jwt=null;
		code=-1;
		accountjwt=null;
	}
	
	private int code=-1;
	private String msg;
	private Object data;
	private String jwt;
	private String accountjwt;
	
	public int getCode() {
		return code;
	}
	public AjaxResult setCode(int code) {
		this.code = code;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public AjaxResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getData() {
		return data;
	}
	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getAccountJwt() {
		return accountjwt;
	}
	public void setAccountJwt(String accountjwt) {
		this.accountjwt = accountjwt;
	}
}
