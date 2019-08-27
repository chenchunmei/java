package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Order;
import com.remarkable.mapper.EmpMapper;
import com.remarkable.service.IEmpService;

/**
 * 骑手服务层
 * @author Sun
 *
 */
@Service
public class EmpServiceImpl implements IEmpService {

	//调用骑手mapper层
	@Autowired
	private EmpMapper empMapper;
	
	/**
	 * 查询骑手的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	public List<Order> findOrderAll(int emp_id,String ord_code,int com_id,int add_id){
		return empMapper.findOrderAll(emp_id, ord_code, com_id, add_id);
	}
	
	/**
	 * 查询骑手未送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	public List<Order> findNoOrderAndEmpAll(int emp_id,String ord_code,int com_id,int add_id){
		return empMapper.findNoOrderAndEmpAll(emp_id, ord_code, com_id, add_id);
	}
	
	/**
	 * 查询骑手已经送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	public List<Order> findOrderAndEmpAll(int emp_id,String ord_code,int com_id,int add_id){
		return empMapper.findOrderAndEmpAll(emp_id, ord_code, com_id, add_id);
	}
	
	/**
	 * 查询骑手转交的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	public List<Order> findSendOrderByForward(int emp_id,String ord_code,int com_id,int add_id){
		return empMapper.findSendOrderByForward(emp_id, ord_code, com_id, add_id);
	}
	
	/**
	 * 查询骑手收到转交的所有订单
	 * @param ord_forward
	 * @param ord_code
	 * @param com_id
	 * @return
	 */
	public List<Order> findPutOrderByForward(int ord_forward,String ord_code,int com_id){
		return empMapper.findPutOrderByForward(ord_forward, ord_code, com_id);
	}

	/**
	 * 根据订单id查询订单详情
	 * @param ord_id
	 * @return
	 */
	public Order findOrderById(int ord_id){
		return empMapper.findOrderById(ord_id);
	}
}
