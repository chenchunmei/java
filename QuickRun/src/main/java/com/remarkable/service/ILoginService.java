package com.remarkable.service;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
	Integer updateUserPwd(Integer u_id,String u_pwd,String u_oldPwd);
	
	/**
	 * 修改骑手密码
	 * @param emp_id 骑手id
	 * @param emp_pwd 骑手密码
	 * @return
	 */
	Integer updateEmpPwd(Integer emp_id,String emp_pwd,String emp_oldPwd);
}
