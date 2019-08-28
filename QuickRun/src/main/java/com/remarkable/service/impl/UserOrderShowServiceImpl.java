package com.remarkable.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Order;
import com.remarkable.entity.Rectime;
import com.remarkable.mapper.UserOrderShowMapper;
import com.remarkable.service.IUserOrderShowService;

/**
 * 订单显示接口实现层
 * @author 王慧
 *
 */
@Service
public class UserOrderShowServiceImpl implements IUserOrderShowService{
	
	@Autowired
	private UserOrderShowMapper userOrderShowMapper;

	
	/**
	 * 根据用户ID,订单编号，订单状态查询订单信息 
	 * @param u_id
	 * @param ord_code
	 * @return
	 */
	@Override
	public List<Order> findOrderByUid(int u_id,String ord_code) {
		return userOrderShowMapper.findOrderByUid(u_id,ord_code);
	}


	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_code 订单编号
	 * @return
	 */
	@Override
	public Order findOrderdetailsByordId(String ord_code) {
		return userOrderShowMapper.findOrderdetailsByordId(ord_code);
	}


	/**
	 * 删除用户订单记录（根据订单编号修改订单状态）
	 * @param ord_code 订单编号
	 * @return
	 */
	@Override
	public int deleteUserOrder(String ord_code) {
		return userOrderShowMapper.deleteUserOrder( ord_code);
	}
}
