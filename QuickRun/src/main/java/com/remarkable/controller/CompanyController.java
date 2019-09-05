package com.remarkable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.Company;
import com.remarkable.service.ICompanyService;

/**
 * 快递公司控制层
 * @author Sun
 *
 */
@Controller
/*@CrossOrigin(origins = {"*", "null"})*/
public class CompanyController {

	//调用快递公司服务层
	@Autowired
	private ICompanyService companyServiceImpl;
	
	/**
	 * 查询所有快递公司
	 * @return
	 */
	@RequestMapping("/companyAll.action")
	public @ResponseBody List<Company> findCompanyAll(){
		List<Company> companyList = companyServiceImpl.findCompanyAll();
		return companyList;
	}
	
}
