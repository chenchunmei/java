package com.remarkable.service;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;

/**
 * 公司管理服务层
 * @author 李明哲
 *
 */
public interface ICompanyManagerService {
	
	
	PageInfo<Company> showCompany(Integer page,Integer pageSize);
		
	PageInfo<Company> selectCompanyLike(String com_name,Integer page,Integer pageSize);
	
	int deletecompany(Integer com_id );
	
	int updateState(Integer com_state,String com_id);
	
	Company selectCompanyById(Integer com_id);
	
	public void insertCompany(Company company);
	
	int updateCompany(Company company);
	

}
