package com.remarkable.entity;

/**
 * 管理员实体类
 * @author 向林俊
 *
 */
public class Admin {

	private int adm_id;
	
	private String adm_account;
	
	private String adm_pwd;
	
	private int adm_state;

	public int getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(int adm_id) {
		this.adm_id = adm_id;
	}

	public String getAdm_account() {
		return adm_account;
	}

	public void setAdm_account(String adm_account) {
		this.adm_account = adm_account;
	}

	public String getAdm_pwd() {
		return adm_pwd;
	}

	public void setAdm_pwd(String adm_pwd) {
		this.adm_pwd = adm_pwd;
	}

	public int getAdm_state() {
		return adm_state;
	}

	public void setAdm_state(int adm_state) {
		this.adm_state = adm_state;
	}
	
}
