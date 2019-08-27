package com.remarkable.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.remarkable.entity.Emp;
import com.remarkable.entity.User;

/**
 * 个人中心
 * @author ASUS
 *
 */
@Repository
public interface CenterMapper {
	
	@Insert("insert into tb_user(u_phone,u_nickname,u_sex,u_birthday) "
			+ "values(#{u_phone},#{u_nickname},#{u_sex},#{u_birthday})")
	public void updateUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @return
	 */
	@Select("select u_phone,u_nickname,u_sex,u_birthday from tb_user where u_id=#{u_id}")
	public User findUserById(int u_id);
	
	/**
	 * 根据员工id查询员工信息
	 * @param emp_id
	 * @return
	 */
	@Select("select * from tb_emp where emp_id = #{emp_id}")
	public Emp findEmpById(Integer emp_id);
	
	/**
	 * 根据员工id修改员工信息
	 * @param emp
	 * @return
	 */
	@Update("update tb_emp set emp_major = #{emp_major}, emp_phone = #{emp_phone}, emp_dormitory = #{emp_dormitory} where emp_id =#{emp_id}")
	public int updateEmp(Emp emp);

}
