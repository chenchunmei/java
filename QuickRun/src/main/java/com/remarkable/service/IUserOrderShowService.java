package com.remarkable.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	 * 根据用户ID查找订单信息
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
	
}
