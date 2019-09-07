package com.remarkable.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Address;
import com.remarkable.entity.Company;
import com.remarkable.entity.Emp;
/**
 * 地址管理服务层
 * @author 李明哲
 *
 */
public interface IAddressManagerService {
	
	PageInfo<Address> showAdd(Integer page,Integer pageSize);
	
	int deleteAdd(Integer add_id );
	
	int updateState(Integer add_state,String add_id);
	
	List<Emp> SelectEmpName();
	
	int updateEmpid(Integer emp_id,String add_id);
	
	public void insertAddress(Address address);

}
