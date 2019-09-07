package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.mapper.CompanyManagerMapper;
import com.remarkable.service.ICompanyManagerService;
/**
 * 公司管理接口实现层
 * @author 李明哲
 *
 */
@Service
public class CompanyManagerServiceImpl implements ICompanyManagerService{
	
	@Autowired
	private CompanyManagerMapper cmm;

	@Override
	public PageInfo<Company> showCompany(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Company> list = cmm.SelectCompany();			
		PageInfo<Company> pageList = new PageInfo<Company>(list);
		return pageList;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public PageInfo<Company> selectCompanyLike(String com_name,Integer page,Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Company> list =cmm.selectCompanyLike("%"+com_name+"%");
		PageInfo<Company> pageList = new PageInfo<Company>(list);
		return pageList;
	}

	@Override
	public int deletecompany(Integer com_id) {		
		return cmm.deletecompany(com_id);
	}

	@Override
	public int updateState(Integer com_state, String com_id) {
		return cmm.updateState(com_state, com_id);
	}

	@Override
	public Company selectCompanyById(Integer com_id) {		
		return cmm.selectCompanyById(com_id);
	}

	@Override
	public void insertCompany(Company company) {
		cmm.insertCompany(company);		
	}

	@Override
	public int updateCompany(Company company) {
		return cmm.updateCompany(company);
	} 
	
}
