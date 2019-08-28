package com.remarkable.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.remarkable.entity.Company;
import com.remarkable.entity.Order;
import com.remarkable.service.IUserOrderShowService;


@CrossOrigin
@Controller
public class UserOrderShowController {
	
	@Autowired
	private IUserOrderShowService userOrderShowServiceImpl;
	
	/**
	 * 根据用户ID 查询订单信息
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectorderbyuid.action")
	@ResponseBody
	public List<Order> findOrderByUid() {
		List<Order> orderList=new ArrayList<Order>(); 
		orderList = userOrderShowServiceImpl.findOrderByUid(1);
		for (Order order : orderList) {
			System.out.println(order);
		}
		
		return orderList;
	}
	
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_id
	 * @return
	 */
	@RequestMapping("/findOrderdetailsByordId.action")
	@ResponseBody
	public Order findOrderdetailsByordId(Order order) {
		order.setOrd_id(7);
		Order orders =userOrderShowServiceImpl.findOrderdetailsByordId(order.getOrd_id());
		System.out.println("==================");
		System.out.println(orders);
		return orders;
	}
	
	/**
	 * 删除用户订单记录（根据订单ID修改订单状态）
	 */
	@RequestMapping("/deleteUserOrder.action")
	@ResponseBody
	public int deleteUserOrder(int ord_id) {
		int count=userOrderShowServiceImpl.deleteUserOrder(ord_id);
		return count;
	}
}
