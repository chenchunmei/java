package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Address;
import com.remarkable.entity.Emp;
import com.remarkable.mapper.AddressManagerMapper;
import com.remarkable.service.IAddressManagerService;
/**
 * 地址管理接口实现层
 * @author 李明哲
 *
 */
@Service
public class AddressManagerServiceImpl implements IAddressManagerService {
	
	@Autowired
	private AddressManagerMapper amm;

	@Override
	public PageInfo<Address> showAdd(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Address> list =amm.SelectAdd();			
		PageInfo<Address> pageList = new PageInfo<Address>(list);
		return pageList;
	}

	@Override
	public int deleteAdd(Integer add_id) {
		return amm.deleteAdd(add_id);
	}

	@Override
	public int updateState(Integer add_state, String add_id) {
		return amm.updateState(add_state, add_id);
	}

	@Override
	public List<Emp> SelectEmpName() {
		return amm.SelectEmpname();
	}

	@Override
	public int updateEmpid(Integer emp_id, String add_id) {
		return amm.updateEmpid(emp_id, add_id);
	}

	@Override
	public void insertAddress(Address address) {
		amm.insertAddress(address);
	}

}
