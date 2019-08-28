package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Address;
import com.remarkable.mapper.AddressMapper;
import com.remarkable.service.IAddressService;

/**
 * 地址接口
 * @author Sun
 *
 */
@Service
public class AddressServiceImpl implements IAddressService {

	//调用地址mapper层
	@Autowired
	private AddressMapper addressMapper;
	
	/**
	 * 根据骑手id查询地址
	 * @param emp_id
	 * @return
	 */
	public List<Address> findAddressByEmpId(int emp_id) {
		return addressMapper.findAddressByEmpId(emp_id);
	}

}
