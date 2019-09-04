package com.remarkable.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.Address;
import com.remarkable.entity.Company;
import com.remarkable.entity.Order;
import com.remarkable.entity.Rectime;
import com.remarkable.entity.User;
import com.remarkable.service.IAddOrdersService;

/**
 * 用户发布订单
 * @author 王慧
 *
 */
@Controller
@CrossOrigin(origins = {"*", "null"})
public class AddOrdersController {
	
	@Autowired
	private IAddOrdersService addOrdersServiceImpl;
	
	
	/**
	 * 添加发布信息
	 * @param order
	 * @param res
	 */
	@RequestMapping("/insert.action")
	@ResponseBody
	public void insertOrder(Order order,HttpServletResponse res){
		//跨域问题
		res.setHeader("Access-Control-Allow-Origin", "*");
		//获得订单编号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String ord_code =sdf.format(new Date())+(new Random().nextInt(900)+100);
		//取得发布时间
		Date ord_send_time=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//format.format(ord_send_time);
		//==========================取得当前登录用户的用户信息对象
		Subject currentUser = SecurityUtils.getSubject();
		User user = (User) currentUser.getPrincipal();
		int u_id = user.getU_id();
		//==========================取得当前登录用户的用户信息对象
		order.setU_id(u_id);
		order.setOrd_code(ord_code);
		order.setOrd_send_time(ord_send_time);
		addOrdersServiceImpl.insertOrder(order);
	}
	
	/**
	 * 查询快递公司
	 * @return
	 */
	@RequestMapping("/query.action")
	@ResponseBody
	public List<Company> queryCom() {
		List<Company> comList=new ArrayList<Company>(); 
		comList = addOrdersServiceImpl.queryCom();
		return comList;
	}
	
	/**
	 * 查询接收地址
	 * @return
	 */
	@RequestMapping("/queryAdd.action")
	@ResponseBody
	public List<Address> queryAdd() {
		List<Address> addList=new ArrayList<Address>(); 
		addList = addOrdersServiceImpl.queryAdd();
		return addList;
	}
	
	/**
	 * 查询接收时间
	 * @return
	 */
	@RequestMapping("/queryTime.action")
	@ResponseBody
	public List<Rectime> queryTime() {
		List<Rectime> timeList=new ArrayList<Rectime>(); 
		timeList = addOrdersServiceImpl.queryTime();
		return timeList;
	}
}
