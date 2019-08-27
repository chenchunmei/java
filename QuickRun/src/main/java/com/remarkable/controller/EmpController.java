package com.remarkable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.AjaxResult;
import com.remarkable.entity.Order;
import com.remarkable.service.IEmpService;

/**
 * 骑手控制层
 * @author Sun
 *
 */
@Controller
public class EmpController {

	//调回骑手服务层
	@Autowired
	private IEmpService empServiceImpl;
	//返回前端数据载体
	AjaxResult result = new AjaxResult();
	
	/**
	 * 查询骑手的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	@RequestMapping("/orderEmpAll.action")
	public @ResponseBody AjaxResult findOrderAll(Model model,int emp_id,String ord_code,int com_id,int add_id){
		List<Order> orderList = empServiceImpl.findOrderAll(emp_id, ord_code, com_id, add_id);
		return result.setCode(1).setData(orderList);
	}
	
	/**
	 * 查询骑手未送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	@RequestMapping("/orderEmpNo.action")
	public @ResponseBody AjaxResult findNoOrderAndEmpAll(Model model,int emp_id,String ord_code,int com_id,int add_id){
		List<Order> orderList = empServiceImpl.findNoOrderAndEmpAll(emp_id, ord_code, com_id, add_id);
		return result.setCode(1).setData(orderList);
	}
	
	/**
	 * 查询骑手已经送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	@RequestMapping("/orderEmpNo.action")
	public @ResponseBody AjaxResult findOrderAndEmpAll(Model model,int emp_id,String ord_code,int com_id,int add_id){
		List<Order> orderList = empServiceImpl.findOrderAndEmpAll(emp_id, ord_code, com_id, add_id);
		return result.setCode(1).setData(orderList);
	}
	
	/**
	 * 查询骑手转交的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	@RequestMapping("/orderForwardSend.action")
	public @ResponseBody AjaxResult findSendOrderByForward(Model model,int emp_id,String ord_code,int com_id,int add_id){
		List<Order> orderList = empServiceImpl.findSendOrderByForward(emp_id, ord_code, com_id, add_id);
		return result.setCode(1).setData(orderList);
	}
	
	/**
	 * 查询骑手收到转交的所有订单
	 * @param ord_forward
	 * @param ord_code
	 * @param com_id
	 * @return
	 */
	@RequestMapping("/orderForwardPut.action")
	public @ResponseBody AjaxResult findPutOrderByForward(Model model,int ord_forward,String ord_code,int com_id){
		List<Order> orderList = empServiceImpl.findPutOrderByForward(ord_forward, ord_code, com_id);
		return result.setCode(1).setData(orderList);
	}
	
	/**
	 * 根据订单id查询订单详情
	 * @param ord_id
	 * @return
	 */
	@RequestMapping("/orderDetailEmp.action")
	public @ResponseBody AjaxResult findOrderById(Model model,int ord_id){
		Order order = empServiceImpl.findOrderById(ord_id);
		return result.setCode(1).setData(order);
	}
}
