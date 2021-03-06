package com.remarkable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Order;
import com.remarkable.service.IEmpOrderService;

/**
 * 骑手控制层
 * @author Sun
 *
 */
@Controller
public class EmpOrderController {

	//调用骑手服务层
	@Autowired
	private IEmpOrderService empOrderServiceImpl;
	
	/**
	 * 查询骑手的所有订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderEmpAll.action")
	public @ResponseBody List<Order> findOrderAll(Order order){
		List<Order> orderList = empOrderServiceImpl.findOrderAll(order.getEmp_id(), order.getOrd_code(), order.getCom_id(), order.getAdd_id());
		return orderList;
	}
	
	/**
	 * 查询骑手未送达的所有订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderEmpNo.action")
	public @ResponseBody List<Order> findNoOrderAndEmpAll(Order order){
		List<Order> orderList = empOrderServiceImpl.findNoOrderAndEmpAll(order.getEmp_id(), order.getOrd_code(), order.getCom_id(), order.getAdd_id());
		return orderList;
	}
	
	/**
	 * 查询骑手已经送达的所有订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderEmp.action")
	public @ResponseBody List<Order> findOrderAndEmpAll(Order order){
		List<Order> orderList = empOrderServiceImpl.findOrderAndEmpAll(order.getEmp_id(), order.getOrd_code(), order.getCom_id(), order.getAdd_id());
		return orderList;
	}
	
	/**
	 * 查询骑手转交的所有订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderForwardSend.action")
	public @ResponseBody List<Order> findSendOrderByForward(Order order){
		List<Order> orderList = empOrderServiceImpl.findSendOrderByForward(order.getEmp_id(), order.getOrd_code(), order.getCom_id(), order.getAdd_id());
		return orderList;
	}
	
	/**
	 * 查询骑手收到转交的所有订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderForwardPut.action")
	public @ResponseBody List<Order> findPutOrderByForward(Order order){
		List<Order> orderList = empOrderServiceImpl.findPutOrderByForward(order.getOrd_forward(), order.getOrd_code(), order.getCom_id());
		return orderList;
	}
	
	/**
	 * 根据订单id查询订单详情
	 * @param order
	 * @return
	 */
	@RequestMapping("/orderDetailEmp.action")
	public @ResponseBody Order findOrderById(Order order){
		Order ord = empOrderServiceImpl.findOrderById(order.getOrd_id());
		return ord;
	}
	
	/**
	 * 骑手确认送达快递
	 * @param order
	 * @return
	 */
	@RequestMapping("/updateOrderDelivery.action")
	public @ResponseBody int updateOrderDelivery(Order order) {
		int num = empOrderServiceImpl.updateOrderDelivery(order.getOrd_id());
		return num;
	}
	
	/**
	 * 骑手转交快递
	 * @param order
	 * @return
	 */
	@RequestMapping("/updateOrderForward.action")
	public @ResponseBody int updateOrderForward(Order order) {
		int num = empOrderServiceImpl.updateOrderForward(order.getOrd_id(),order.getOrd_forward());
		return num;
	}
	
	/**
	 * 查询所有正常骑手
	 * @return
	 */
	@RequestMapping("/findEmpAll.action")
	public @ResponseBody List<Emp> findEmpAll(Emp emp){
		List<Emp> empList = empOrderServiceImpl.findEmpAll(emp.getEmp_id());
		return empList;
	}
}
