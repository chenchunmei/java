package com.remarkable.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.Order;
import com.remarkable.entity.User;
import com.remarkable.service.IUserOrderShowService;

/**
 * 用户订单显示
 * @author 王慧
 *
 */
@Controller
@CrossOrigin(origins = {"*", "null"})
public class UserOrderShowController {
	
	@Autowired
	private IUserOrderShowService userOrderShowServiceImpl;
	
	
	
	/**
	 * 根据用户ID,订单编号，订单状态查询订单信息 
	 * @param u_id
	 * @param ord_code
	 * @return
	 */
	@RequestMapping("/selectorderbyuid.action")
	@ResponseBody
	public List<Order> findOrderByUid(String ord_code) {
		System.err.println("订单编号========="+ord_code);
		//==========================取得当前登录用户的用户信息对象
		Subject currentUser = SecurityUtils.getSubject();
		User user = (User) currentUser.getPrincipal();
		//==========================取得当前登录用户的用户信息对象
		List<Order> orderList=new ArrayList<Order>();
		//--------------------------------------------------得到当前用户id
		orderList = userOrderShowServiceImpl.findOrderByUid(user.getU_id(),ord_code);
		for (Order order : orderList) {
			System.out.println(order);
		}
		return orderList;
	}
	
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_code 订单编号
	 * @return
	 */
	@RequestMapping("/findOrderdetailsByordId.action")
	@ResponseBody
	public Order findOrderdetailsByordId(String ord_code) {
		Order orders =userOrderShowServiceImpl.findOrderdetailsByordId(ord_code);
		System.out.println("==================");
		System.out.println(orders);
		return orders;
	}
	
	/**
	 * 删除用户订单记录（根据订单编号修改订单状态）
	 * @param ord_code 订单编号
	 * @return
	 */
	@RequestMapping("/deleteUserOrder.action")
	@ResponseBody
	public int deleteUserOrder(String ord_code) {
		int count=userOrderShowServiceImpl.deleteUserOrder(ord_code);
		System.out.println(count);
		return count;
	}
}
