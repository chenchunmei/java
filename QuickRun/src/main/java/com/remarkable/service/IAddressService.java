package com.remarkable.service;

import java.util.List;

import com.remarkable.entity.Address;

/**
 * 地址服务层
 * @author Sun
 *
 */
public interface IAddressService {

	/**
	 * 根据骑手id查询地址
	 * @param emp_id
	 * @return
	 */
	List<Address> findAddressByEmpId(int emp_id);
}
