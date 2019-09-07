package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.entity.Emp;
import com.remarkable.entity.User;
import com.remarkable.mapper.EmpManagerMapper;
import com.remarkable.service.IEmpManagerService;
/**
 * 骑手管理接口实现层
 * @author 李明哲
 *
 */
@Service
public class EmpManagerServiceImpl implements IEmpManagerService {

	@Autowired
	private EmpManagerMapper emm;
	
	@Override
	public PageInfo<Emp> showEmp(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Emp> list = emm.SelectEmp();		
		PageInfo<Emp> pageList = new PageInfo<Emp>(list);
		return pageList;
	}

	@Override
	public PageInfo<Emp> selectEmpLike(String emp_name, String emp_phone, Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Emp> list =emm.selectEmpLike("%"+emp_name+"%", "%"+emp_phone+"%");
		PageInfo<Emp> pageList = new PageInfo<Emp>(list);
		return pageList;
	}

	@Override
	public int deleteEmp(Integer emp_id) {
		
		return emm.deleteEmp(emp_id);
	}

	@Override
	public int updateState(Integer emp_state, String emp_id) {
		return emm.updateState(emp_state, emp_id);
	}

	@Override
	public Emp selectEmpById(Integer emp_id) {
		return emm.selectEmpById(emp_id);
	}

	@Override
	public void insertEmp(Emp emp) {
		emm.insertEmp(emp);
		
	}

	@Override
	public int updateEmp(Emp emp) {
		return emm.updateEmp(emp);
	}
	
	

}
