package com.remarkable.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.remarkable.entity.User;
import com.remarkable.service.ILoginService;

/**
 * 登录Service层实现类
 * @author 向林俊
 *
 */
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginService loginService;
	
	/**
	 * 登录
	 * @param phone 手机号
	 * @param pwd 密码
	 * @return 用户信息
	 */
	@Override
	public User login(String phone) {
		User user = loginService.login(phone);
		return user;
	}

	/**
	 * 注册
	 * @param phone 手机号
	 * @param pwd 密码
	 * @return 影响行数
	 */
	@Override
	public int register(String phone, String pwd) {
		int row = loginService.register(phone, pwd);
		return row;
	}

	/**
	 * 根据手机号查询角色名称
	 * @param phone
	 * @return
	 */
	@Override
	public Set<String> getRoles(String phone) {
		Set<String> roles = loginService.getRoles(phone);
		return roles;
	}
	
	/**
	 * 根据手机号查询用户权限名称
	 * @param phone
	 * @return
	 */
	public Set<String> getPerms(String phone){
		Set<String> perms = loginService.getPerms(phone);
		return perms;
	}

}