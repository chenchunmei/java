package com.remarkable.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.remarkable.entity.Emp;
import com.remarkable.entity.User;
import com.remarkable.service.ICenterService;
import com.remarkable.service.impl.CenterServiceImpl;

@CrossOrigin
@Controller
public class CenterController {
	
	@Autowired
	private ICenterService centerServiceImpl;

	@RequestMapping("/updateUser.action")
	@ResponseBody
	public void updateUser(User user,HttpServletResponse res){
		res.setHeader("Access-Control-Allow-Origin", "*");
		centerServiceImpl.updateUser(user);
	}
	
	
	@RequestMapping("/showUser.action")
	public @ResponseBody User showUser(Model model,HttpServletRequest request){
		int u_id =1;
		User user=centerServiceImpl.findUserById(u_id);
		System.out.println(user);
		return user;
	}
	
	@RequestMapping("/showEmp")
	@ResponseBody
	public Emp showEmp(){
		int emp_id = 1;
		Emp emp = centerServiceImpl.findEmpById(emp_id);
		System.out.println(emp);
		return emp;
	}
	
	@RequestMapping("/updateEmp")
	@ResponseBody
	public int updateEmp(){
		Emp emp = new Emp();
		emp.setEmp_id(1);
		emp.setEmp_dormitory("A5");
		emp.setEmp_major("物联网工程");
		emp.setEmp_phone("15289986265");
		int count= centerServiceImpl.updateEmp(emp);
		System.out.println(count);
		return count;
		
	}
}
