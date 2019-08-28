package com.remarkable.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.remarkable.entity.Order;

/**
 * 骑手服务层接口
 * @author Sun
 *
 */
public interface IEmpOrderService {

	/**
	 * 查询骑手的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findOrderAll(int emp_id,String ord_code,int com_id,int add_id);
	
	/**
	 * 查询骑手未送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findNoOrderAndEmpAll(int emp_id,String ord_code,int com_id,int add_id);
	
	/**
	 * 查询骑手已经送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findOrderAndEmpAll(int emp_id,String ord_code,int com_id,int add_id);
	
	/**
	 * 查询骑手转交的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findSendOrderByForward(int emp_id,String ord_code,int com_id,int add_id);
	
	/**
	 * 查询骑手收到转交的所有订单
	 * @param ord_forward
	 * @param ord_code
	 * @param com_id
	 * @return
	 */
	List<Order> findPutOrderByForward(int ord_forward,String ord_code,int com_id);
	
	/**
	 * 根据订单id查询订单详情
	 * @param ord_id
	 * @return
	 */
	Order findOrderById(int ord_id);
	
	/**
	 * 骑手确认送达快递
	 * @param ord_id
	 * @return
	 */
	int updateOrderDelivery(int ord_id);
	
	/**
	 * 骑手转交快递
	 * @param ord_id
	 * @param ord_forward
	 * @return
	 */
	int updateOrderForward(int ord_id,int ord_forward);
}
