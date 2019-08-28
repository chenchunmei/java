package com.remarkable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;
import com.remarkable.mapper.CenterMapper;
import com.remarkable.service.ICenterService;

@Service
public class CenterServiceImpl implements ICenterService{
	
	@Autowired
	private CenterMapper centerMapper;

	public Integer updateUser(User user) {
		return centerMapper.updateUser(user);
	}

	public User findUserById(int u_id) {
		User user = centerMapper.findUserById(u_id);
		return user;
	}

	public Emp findEmpById(Integer emp_id) {
		Emp emp = centerMapper.findEmpById(emp_id);
		return emp;
	}

	public int updateEmp(Emp emp) {
		int count = centerMapper.updateEmp(emp);
		return count;
	}

	public Integer insertImages(Images images) {
		return centerMapper.insertImages(images);
	}

	public Images findImagesByid(Integer u_id) {
		return centerMapper.findImagesByid(u_id);
	}
	/**
	 * 根据订单编号投诉
	 * @param ord_complaint 投诉信息
	 * @param ord_code 订单编号
	 * @return
	 */
	public Integer insertCompaint(String ord_complaint, String ord_code,Integer emp_id) {
		findComplaintCount(emp_id);
		return centerMapper.insertCompaint(ord_complaint, ord_code);
	}

	@Override
	public boolean findComplaintCount(Integer emp_id) {
		Integer count = centerMapper.findComplaintCount(emp_id);
		System.out.println(count);
		boolean isRun = false;
		if(count > 3){
			centerMapper.reduceEmpCredit(emp_id);
			isRun = true;
		}
		return isRun;
	}

	
	public void judgeInsertImages(Images images, Integer u_id) {
		Integer result=centerMapper.findImageByU_Id(u_id);
		if(result == 0){
			centerMapper.insertImages(images);
		}else{
			centerMapper.updateImages(images);
		}
	}
}
