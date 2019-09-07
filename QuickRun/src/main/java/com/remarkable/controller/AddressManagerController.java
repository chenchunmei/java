package com.remarkable.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Address;
import com.remarkable.entity.Emp;
import com.remarkable.service.IAddressManagerService;
/**
 * 地址后台管理控制层
 * @author 李明哲
 *
 */
@Controller
@CrossOrigin(origins={"*","null"})
public class AddressManagerController {
	
	@Autowired
	private IAddressManagerService iams;
	
	@RequestMapping("AddManager.action")
	public @ResponseBody PageInfo<Address> showTables(Integer page, Integer pageSize){
			PageInfo<Address> pageList=null;
			pageList =iams.showAdd(page, pageSize);
			return pageList;
	}
	
	@RequestMapping("AddManagerDelete.action")
	public String deleteAdd(Integer add_id,HttpServletResponse res) {
		iams.deleteAdd(add_id);
		return "AddManager.action";
	}
	
	@RequestMapping("AddManagerUpdate.action")
	public String updateAddState(Integer add_state, String add_id,HttpServletResponse res) {
		iams.updateState(add_state, add_id);
		return "AddManager.action";
	}
	
	@RequestMapping("SelectEmpname.action")
	public  @ResponseBody List<Emp>  SelectEmpname()  {
		return iams.SelectEmpName();
	}
	
	@RequestMapping("AddManagerEmpid.action")
	public String updateAddStateEmpid(Integer emp_id, String add_id,HttpServletResponse res) {
		iams.updateEmpid(emp_id, add_id);
		return "AddManager.action";
	}
	
	@RequestMapping("insertAddress.action")
	@ResponseBody
	@CrossOrigin
	public void insertCompany(Address address,HttpServletResponse res){	
		res.setHeader("Access-Control-Allow-Origin", "*");
		iams.insertAddress(address);
	}
}
