package com.remarkable.entity;

import java.io.Serializable;

/**
 * 用户头像
 * @author ASUS
 *
 */
public class Images implements Serializable{

	private Integer ima_id;
	private String ima_address;
	private Integer u_id;
	private User user;
	
	public Integer getIma_id() {
		return ima_id;
	}
	public void setIma_id(Integer ima_id) {
		this.ima_id = ima_id;
	}
	public String getIma_address() {
		return ima_address;
	}
	public void setIma_address(String ima_address) {
		this.ima_address = ima_address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Images [ima_id=" + ima_id + ", ima_address=" + ima_address + ", u_id=" + u_id + ", user=" + user + "]";
	}
	
	
}
