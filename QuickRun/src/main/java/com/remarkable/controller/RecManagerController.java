package com.remarkable.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.entity.Rectime;
import com.remarkable.entity.User;
import com.remarkable.service.IRecManagerService;

@Controller
@CrossOrigin(origins={"*","null"})
public class RecManagerController {
	
	@Autowired
	private IRecManagerService ims;
	
	@RequestMapping("RecManager.action")
	public @ResponseBody PageInfo<Rectime> showTables(String u_phone, String u_nickname, Integer page, Integer pageSize){
			PageInfo<Rectime> pageList=null;
			pageList = ims.showRec(page, pageSize);
			return pageList;
	}
	
	@RequestMapping("RecManagerDelete.action")
	public String deleteRec(Integer rec_id,HttpServletResponse res) {
		ims.deleteRec(rec_id);
		return "RecManager.action";
	}
	
	@RequestMapping("RecManagerUpdate.action")
	public String updateRecState(Integer rec_state, String rec_id,HttpServletResponse res) {
		ims.updateState(rec_state, rec_id);
		return "RecManager.action";
	}
	
	@RequestMapping("insertRec.action")
	@ResponseBody
	@CrossOrigin
	public void insertRec(Rectime rectime,HttpServletResponse res){	
		res.setHeader("Access-Control-Allow-Origin", "*");
		ims.insertRec(rectime);
	}
	

}
