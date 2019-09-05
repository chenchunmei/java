package com.remarkable.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.service.ICompanyManagerService;


@Controller
/*@CrossOrigin(origins={"*","null"})*/
public class CompanyManagerController {
	
	@Autowired
	private ICompanyManagerService cmsi;
	
	@RequestMapping("company1.action")
	public @ResponseBody PageInfo<Company> showTables(String com_name, Integer page, Integer pageSize){
		PageInfo<Company> pageList=null;
		if(com_name ==  null) {
			 pageList = cmsi.showCompany(page, pageSize);
		}else if(com_name != null){
			 pageList = cmsi.selectCompanyLike("%"+com_name+"%", page, pageSize);
		}		
		return pageList;
	}
	@RequestMapping("companydelete.action")
	public String deleteCompany(Integer com_id) {
		cmsi.deletecompany(com_id);
		return "company1.action";
	}
	
	@RequestMapping("companyUpdateState.action")
	public String updateCompanyState(Integer add_state, String com_id) {
		cmsi.updateState(add_state, com_id);
		return "company1.action";
	}
	
	@RequestMapping("selectCompanyByid.action")
	public @ResponseBody Company selectCompanyById(Integer com_id) {
		return cmsi.selectCompanyById(com_id);
	}
	
	@RequestMapping("insertCompany.action")
	@ResponseBody
	@CrossOrigin
	public void insertCompany(Company company,HttpServletResponse res){	
		System.out.println(company);
		res.setHeader("Access-Control-Allow-Origin", "*");
		cmsi.insertCompany(company);
	}
	
	@RequestMapping("updateCompany.action")
	public String updateCompanyState(Company company) {
		cmsi.updateCompany(company);
		return "company1.action";
	}
	
}
