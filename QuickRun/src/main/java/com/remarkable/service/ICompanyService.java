package com.remarkable.service;

import java.util.List;

import com.remarkable.entity.Company;

/**
 * 快递公司业务层
 * @author Sun
 *
 */
public interface ICompanyService {

	/**
	 * 查询所有快递公司
	 * @return
	 */
	List<Company> findCompanyAll();
}
