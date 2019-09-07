package com.remarkable.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Admin;
import com.remarkable.entity.Emp;
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
	 * 根据管理员账号和密码查询
	 * @param adm_account
	 * @param adm_pwd
	 * @return
	 */
	public Admin selAdminByAccAndPwd(String adm_account,String adm_pwd) {
		Admin admin = loginMapper.selAdminByAccAndPwd(adm_account, adm_pwd);
		return admin;
	}
	
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
	 * 骑手登录
	 */
	@Override
	public Emp loginEmp(String emp_sno,String emp_pwd) {
		Emp emp = loginMapper.selEmpBySno(emp_sno,emp_pwd);
		return emp;
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
	public Integer updateUserPwd(Integer u_id,String u_pwd,String u_oldPwd){
		//原始的密码
		String old_pwd=loginMapper.findUserPwdById(u_id);
		//对比原始密码和输入的原始密码是否一致
		if(u_oldPwd.equals(old_pwd)){
			//一致就将其保存在数据库
			return loginMapper.updateUserPwd(u_id,u_pwd);
		}else{
			//不一致就返回0
			return 0;
		}
	}
	
	/**
	 * 根据用户Id修改用户密码
	 * @param u_id
	 * @param u_pwd
	 * @return
	 */
	public Integer returnPwd(String u_phone,String u_pwd){
		Integer row = loginMapper.returnPwd(u_phone, u_pwd);
		return row;
	}
	
	/**
	 * 骑手修改密码
	 * @param emp_id 骑手id
	 * @param emp_pwd 骑手新密码
	 * @param emp_oldPwd 骑手旧密码
	 * @return
	 */
	public Integer updateEmpPwd(Integer emp_id,String emp_pwd,String emp_oldPwd){
		//原始的密码
		String old_pwd=loginMapper.findEmpPwdById(emp_id);
		//对比原始密码和输入的原始密码是否一致
		if(emp_oldPwd.equals(old_pwd)){
			//一致就将其保存在数据库
			return loginMapper.updateEmpPwd(emp_id,emp_pwd);
		}else{
			//不一致就返回0
			return 0;
		}
	}
}
