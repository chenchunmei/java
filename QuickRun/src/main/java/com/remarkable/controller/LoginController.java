package com.remarkable.controller;

import javax.servlet.http.HttpSession;

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

import com.remarkable.entity.User;
import com.remarkable.service.ILoginService;

@Controller
@CrossOrigin(origins = {"*", "null"})
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/login.action")
	public @ResponseBody int login(@RequestParam("phone") String phone
			,@RequestParam("pwd") String pwd,HttpSession session) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(phone,pwd);
		System.out.println("sessionid ------------ "+session.getId());
		try {
			currentUser.login(token);
			User user = (User) currentUser.getPrincipal();
			//获取当前用户的id，并且传递到前端
			System.out.println("这是当前登录账号的用户========="+user);
			session.setAttribute("user", user);
			return 1;
		}catch(AuthenticationException ae) {
			System.out.println("登录失败："+ae.getMessage());
			return 0;
		}
	}
	
	@RequestMapping("/getUser.action")
	public @ResponseBody User getUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("sessionid ============== "+session.getId());
		System.out.println("user  : " + user);
		return user;
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





