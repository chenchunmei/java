package com.remarkable.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public void show(User user,HttpServletResponse res){
		res.setHeader("Access-Control-Allow-Origin", "*");
		centerServiceImpl.updateUser(user);
	}
}
