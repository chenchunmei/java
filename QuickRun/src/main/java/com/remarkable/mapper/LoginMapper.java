package com.remarkable.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	@Insert("insert into tb_user(u_phone,u_pwd) values(#{0},#{1})")
	int insUser(String phone,String pwd);
	
	/**
	 * 根据手机号查询角色名称
	 */
	@Select("select role_name from tb_user where u_phone=#{0}")
	Set<String> getRoles(String phone);
	
	/**
	 * 根据手机号查询用户权限名称
	 */
	@Select("select p.permission_name from tb_permission p,tb_user u where u_phone = '#{0}' and u.role_id = p.role_id ")
	Set<String> getPerms(String phone);
	
	/**
	 * 查询用户的原始密码
	 * @param u_id 用户密码
	 * @return
	 */
	@Select("select u_pwd from tb_user where u_id=#{u_id}")
	String findUserPwdById(Integer u_id);
	
	/**
	 * 根据用户名修改账号密码
	 * @param u_id 用户id
	 * @param u_pwd用户密码
	 * @return
	 */
	@Update("update tb_user set u_pwd = #{u_pwd} where u_id = #{u_id}")
	Integer updateUserPwd(@Param("u_id")Integer u_id,@Param("u_pwd")String u_pwd);
	
	/**
	 * 根据骑手id查询骑手的原始密码
	 * @param emp_id 骑手id
	 * @return
	 */
	@Select("select emp_pwd from tb_emp where emp_id = #{emp_id}")
	String findEmpPwdById(Integer emp_id);
	
	/**
	 * 修改骑手密码
	 * @param emp_id 骑手id
	 * @param emp_pwd 骑手密码
	 * @return
	 */
	@Update("update tb_emp set emp_pwd = #{emp_pwd} where emp_id = #{emp_id}")
	Integer updateEmpPwd(@Param("emp_id")Integer emp_id,@Param("emp_pwd")String emp_pwd);

}

