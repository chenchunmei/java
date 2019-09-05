package com.remarkable.service;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Emp;

public interface IEmpManagerService {
	
	PageInfo<Emp> showEmp(Integer page,Integer pageSize);
	
	PageInfo<Emp> selectEmpLike(String emp_name,String emp_phone,Integer page,Integer pageSize);
	
	int deleteEmp(Integer emp_id );
	
	int updateState(Integer emp_state,String emp_id);
	
	Emp selectEmpById(Integer emp_id);
	
	public void insertEmp(Emp emp);
	
	int updateEmp(Emp emp);

}
