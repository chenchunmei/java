package com.remarkable.service;

import java.util.Set;

import com.remarkable.entity.User;

/**
 * 登录Service层接口
 * @author 向林俊
 *
 */
public interface ILoginService {

	/**
	 * 登录
	 * @param phone 手机号
	 * @return 用户信息
	 */
	User login(String phone);
	
	/**
	 * 注册
	 * @param phone 手机号
	 * @param pwd 密码
	 * @return 影响行数
	 */
	int register(String phone,String pwd);
	
	/**
	 * 根据手机号查询角色名称
	 * @param phone
	 * @return
	 */
	Set<String> getRoles(String phone);
	
	/**
	 * 根据手机号查询用户权限名称
	 * @param phone
	 * @return
	 */
	Set<String> getPerms(String phone);
	
	/**
	 * 根据用户Id修改用户密码
	 * @param u_id
	 * @param u_pwd
	 * @return
	 */
	Integer updatePwd(Integer u_id,String u_pwd,String u_oldPwd);
}
