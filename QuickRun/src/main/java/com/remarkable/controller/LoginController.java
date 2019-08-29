package com.remarkable.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.service.ILoginService;

@Controller
@CrossOrigin(origins = {"*", "null"})
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/login.action")
	public @ResponseBody int login(@RequestParam("phone") String phone,@RequestParam("pwd") String pwd) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(phone,pwd);
		try {
			currentUser.login(token);
			return 1;
		}catch(AuthenticationException ae) {
			System.out.println("登录失败："+ae.getMessage());
			return 0;
		}
	}
	
	@RequestMapping("/register.action")
	public @ResponseBody int register(@RequestParam("phone") String phone,@RequestParam("pwd") String pwd) {
		//判断验证码是否正确，如果正确，就执行注册
		
		int result = loginService.register(phone, pwd);
		if(result == 0) {//注册失败
			return 0;
		}else {//注册成功
			return 1;
		}
	}
}





