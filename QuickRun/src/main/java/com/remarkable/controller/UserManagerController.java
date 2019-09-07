package com.remarkable.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.User;
import com.remarkable.service.IUserManagerService;
/**
 * 用户后台管理控制层
 * @author 李明哲
 *
 */
@Controller
@CrossOrigin(origins={"*","null"})
public class UserManagerController {
	
	@Autowired
	private IUserManagerService umsi;
	
	@RequestMapping("UserManager11.action")
	public @ResponseBody PageInfo<User> showTables(String u_phone, String u_nickname, Integer page, Integer pageSize){
		PageInfo<User> pageList=null;
		if(u_phone ==  null && u_nickname==null) {
			 pageList = umsi.showUser(page, pageSize);
		}else if(u_phone != null && u_nickname !=null ){
			 pageList = umsi.selectUserLike("%"+u_phone+"%", "%"+u_nickname+"%", page, pageSize);
		}		
		return pageList;
	}
	
	@RequestMapping("suibianshan.action")
	public String deleteUser(Integer u_id,HttpServletResponse res) {
		umsi.deleteUser(u_id);
		return "UserManager11.action";
	}
	
	@RequestMapping("suibiangai.action")
	public String updateUserState(Integer u_state, String u_id,HttpServletResponse res) {
		umsi.updateState(u_state, u_id);
		return "UserManager11.action";
	}

}
