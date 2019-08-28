package com.remarkable.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Order;
import com.remarkable.entity.User;

/**
 * 
 * @author 王慧
 *
 */
public interface IUserOrderShowService {
	
	
	
	/**
	 * 根据用户ID和状态查找订单信息
	 * @param u_id
	 * @return
	 */
	List<Order> findOrderByUid(int u_id);
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_id
	 * @return
	 */
	Order findOrderdetailsByordId(int ord_id);
	
	/**
	 * 删除用户订单记录（根据订单ID修改订单状态）
	 */
	public int deleteUserOrder(int ord_id);
	
}
