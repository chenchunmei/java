package com.remarkable.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Emp;
import com.remarkable.service.IEmpManagerService;
/**
 * 骑手后台管理控制层
 * @author 李明哲
 *
 */
@Controller
/*@CrossOrigin(origins={"*" ,"null"})*/
public class EmpManagerController {
	
	@Autowired
	private IEmpManagerService ies;
	
	@RequestMapping("EmpManager.action")
	public @ResponseBody PageInfo<Emp> showTables(String emp_name,String emp_phone,Integer page, Integer pageSize){
		PageInfo<Emp> pageList=null;
		if(emp_name ==  null && emp_phone==null ) {
			 pageList = ies.showEmp(page, pageSize);
		}else if(emp_name != null && emp_phone!=null ){
			 pageList = ies.selectEmpLike("%"+emp_name+"%","%"+emp_phone+"%", page, pageSize);
		}		
		return pageList;
	}
	@RequestMapping("EmpManagerDelete.action")
	public String deleteEmp(Integer emp_id) {
		ies.deleteEmp(emp_id);
		return "EmpManager.action";
	}
	
	@RequestMapping("EmpManagerUpdateState.action")
	public String updateEmpState(Integer emp_state, String emp_id) {
		ies.updateState(emp_state, emp_id);
		return "EmpManager.action";
	}
	
	@RequestMapping("selectEmpManagerByid.action")
	public @ResponseBody Emp selectEmpById(Integer emp_id) {
		return ies.selectEmpById(emp_id);
	}
	
	@RequestMapping("insertEmpManager.action")
	@ResponseBody
	@CrossOrigin
	public void insertCompany(Emp emp,HttpServletResponse res){	
		res.setHeader("Access-Control-Allow-Origin", "*");
		ies.insertEmp(emp);
	}
	
	@RequestMapping("updateEmpManager.action")
	public String updateCompanyState(Emp emp) {
		ies.updateEmp(emp);
		return "EmpManager.action";
	}
	
	

}
