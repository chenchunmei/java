package com.remarkable.service;

import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.User;

public interface ICenterService {
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 根据用户名查找用户信息
	 * @param u_id
	 * @return
	 */
	public User findUserById(int u_id);

}
