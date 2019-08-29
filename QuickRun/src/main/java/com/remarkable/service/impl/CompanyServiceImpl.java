package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Company;
import com.remarkable.mapper.CompanyMapper;
import com.remarkable.service.ICompanyService;

/**
 * 快递公司业务层
 * @author Sun
 *
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

	//调用快递公司mapper层
	@Autowired
	private CompanyMapper companyMapper;
	
	/**
	 * 查询所有快递公司
	 * @return
	 */
	public List<Company> findCompanyAll() {
		return companyMapper.findCompanyAll();
	}

}
