package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.remarkable.entity.Order;

/**
 * 骑手接口
 * @author Sun
 *
 */
public interface EmpOrderMapper {

	/**
	 * 查询骑手的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findOrderAll(@Param("emp_id") int emp_id,@Param("ord_code") String ord_code,@Param("com_id") int com_id,@Param("add_id") int add_id);
	
	/**
	 * 查询骑手未送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findNoOrderAndEmpAll(@Param("emp_id") int emp_id,@Param("ord_code") String ord_code,@Param("com_id") int com_id,@Param("add_id") int add_id);
	
	/**
	 * 查询骑手已经送达的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findOrderAndEmpAll(@Param("emp_id") int emp_id,@Param("ord_code") String ord_code,@Param("com_id") int com_id,@Param("add_id") int add_id);
	
	/**
	 * 查询骑手转交的所有订单
	 * @param emp_id
	 * @param ord_code
	 * @param com_id
	 * @param add_id
	 * @return
	 */
	List<Order> findSendOrderByForward(@Param("emp_id") int emp_id,@Param("ord_code") String ord_code,@Param("com_id") int com_id,@Param("add_id") int add_id);
	
	/**
	 * 查询骑手收到转交的所有订单
	 * @param ord_forward
	 * @param ord_code
	 * @param com_id
	 * @return
	 */
	List<Order> findPutOrderByForward(@Param("ord_forward") int ord_forward,@Param("ord_code") String ord_code,@Param("com_id") int com_id);
	
	/**
	 * 根据订单id查询订单详情
	 * @param ord_id
	 * @return
	 */
	Order findOrderById(@Param("ord_id") int ord_id);
}
