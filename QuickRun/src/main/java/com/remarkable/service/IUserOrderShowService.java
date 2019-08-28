package com.remarkable.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Order;
import com.remarkable.entity.User;

/**
 * 订单显示接口
 * @author 王慧
 *
 */
public interface IUserOrderShowService {
	
	
	
	/**
	 * 根据用户ID,订单编号，订单状态查询订单信息 
	 * @param u_id
	 * @param ord_code
	 * @return
	 */
	List<Order> findOrderByUid(int u_id,String ord_code);
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_code 订单编号
	 * @return
	 */
	Order findOrderdetailsByordId(String ord_code);
	
	/**
	 * 删除用户订单记录（根据订单编号修改订单状态）
	 * @param ord_code 订单编号
	 * @return
	 */
	public int deleteUserOrder(String ord_code);
	
}
