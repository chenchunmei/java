package com.remarkable.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.remarkable.entity.User;

@Repository
public interface LoginMapper {

	/**
	 * 根据手机号码查询出用户的所有信息
	 * @param phone
	 * @return
	 */
	@Select("select * from tb_user where u_phone = #{0}")
	User selUserByPhone(String phone);
	
	/**
	 * 注册用户账号
	 * @param phone 手机号
	 * @param pwd 密码
	 * @return
	 */
	@Insert("insert into tb_user(u_phone,u_pwd) values('#{0}','#{1}')")
	int insUser(String phone,String pwd);
	
	/**
	 * 根据手机号查询角色名称
	 */
	@Select("select role_name from tb_user where u_phone='#{0}'")
	Set<String> getRoles(String phone);
	
	/**
	 * 根据手机号查询用户权限名称
	 */
	@Select("select p.permission_name from tb_permission p,tb_user u where u_phone = '#{0}' and u.role_id = p.role_id ")
	Set<String> getPerms(String phone);
}
