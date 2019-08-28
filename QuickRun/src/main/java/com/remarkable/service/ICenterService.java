package com.remarkable.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;

public interface ICenterService {
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public Integer updateUser(User user);
	
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
	
	/**
	 * 添加头像
	 * @param images
	 * @return
	 */
	public Integer insertImages(Images images); 
	
	public Images findImagesByid(Integer u_id);
	
	/**
	 * 根据订单编号投诉
	 * @param ord_complaint 投诉信息
	 * @param ord_code 订单编号
	 * @return
	 */
	public Integer insertCompaint(String ord_complaint,String ord_code,Integer emp_id);
	
	/**
	 * 查询投诉信息的总记录
	 * @param ord_code
	 * @return
	 */
	public boolean findComplaintCount(@Param("emp_id")Integer emp_id);
	
	/**
	 * 判断是否要添加图片
	 * @param images
	 * @param u_id
	 */
	public void judgeInsertImages(Images images,Integer u_id);
	
}
