package com.remarkable.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Address;
import com.remarkable.entity.Rectime;
import com.remarkable.service.IAddressManagerService;
import com.remarkable.service.IRecManagerService;

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

}
