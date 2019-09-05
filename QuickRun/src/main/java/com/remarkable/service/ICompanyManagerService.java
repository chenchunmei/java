package com.remarkable.service;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;


public interface ICompanyManagerService {
	
	
	PageInfo<Company> showCompany(Integer page,Integer pageSize);
		
	PageInfo<Company> selectCompanyLike(String com_name,Integer page,Integer pageSize);
	
	int deletecompany(Integer com_id );
	
	int updateState(Integer add_state,String com_id);
	
	Company selectCompanyById(Integer com_id);
	
	public void insertCompany(Company company);
	
	int updateCompany(Company company);
	

}
