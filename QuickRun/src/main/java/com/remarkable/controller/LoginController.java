package com.remarkable.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = {"*", "null"})
public class LoginController {

	@RequestMapping("/login.action")
	public @ResponseBody int login(@RequestParam("phone") String phone,@RequestParam("pwd") String pwd) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(phone,pwd);
			try {
				currentUser.login(token);
			}catch(AuthenticationException ae) {
				System.out.println("登录失败："+ae.getMessage());
				return 0;
			}
		}
		return 1;
	}
}





