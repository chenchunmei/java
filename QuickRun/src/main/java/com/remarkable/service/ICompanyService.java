package com.remarkable.service;

import java.util.List;

import com.remarkable.entity.Company;

/**
 * 公司业务层
 * @author Sun
 *
 */
public interface ICompanyService {

	/**
	 * 查询所有公司
	 * @return
	 */
	List<Company> findCompanyAll();
}
