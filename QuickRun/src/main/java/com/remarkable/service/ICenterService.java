package com.remarkable.service;

import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.Emp;
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
	
	/**
	 * 根据员工id查询员工信息
	 * @param emp_id
	 * @return
	 */
	public Emp findEmpById(Integer emp_id);
	
	/**
	 * 根据员工id修改员工信息
	 * @param emp
	 * @return
	 */
	public int updateEmp(Emp emp);

}
