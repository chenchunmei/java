package com.remarkable.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.remarkable.entity.User;
import com.remarkable.mapper.LoginMapper;
import com.remarkable.service.ILoginService;

/**
 * 登录Service层实现类
 * @author 向林俊
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	/**
	 * 登录
	 * @param phone 手机号
	 * @param pwd 密码
	 * @return 用户信息
	 */
	@Override
	public User login(String phone) {
		User user = loginMapper.selUserByPhone(phone);
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
		int row = loginMapper.insUser(phone, pwd);
		return row;
	}

	/**
	 * 根据手机号查询角色名称
	 * @param phone
	 * @return
	 */
	@Override
	public Set<String> getRoles(String phone) {
		Set<String> roles = loginMapper.getRoles(phone);
		return roles;
	}
	
	/**
	 * 根据手机号查询用户权限名称
	 * @param phone
	 * @return
	 */
	public Set<String> getPerms(String phone){
		Set<String> perms = loginMapper.getPerms(phone);
		return perms;
	}
	
	/**
	 * 根据用户Id修改用户密码
	 * @param u_id
	 * @param u_pwd
	 * @return
	 */
	public Integer updatePwd(Integer u_id,String u_pwd,String u_oldPwd){
		//原始的密码
		String old_pwd=loginMapper.findPwdById(u_id);
		//对比原始密码和输入的原始密码是否一致
		if(u_oldPwd.equals(old_pwd)){
			//一致就将其保存在数据库
			return loginMapper.updatePwd(u_id,u_pwd);
		}else{
			//不一致就返回0
			return 0;
		}
	}

}
