package com.remarkable.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Order;
import com.remarkable.entity.Rectime;
import com.remarkable.mapper.UserOrderShowMapper;
import com.remarkable.service.IUserOrderShowService;

@Service
public class UserOrderShowServiceImpl implements IUserOrderShowService{
	
	@Autowired
	private UserOrderShowMapper userOrderShowMapper;

	
	/**
	 * 根据用户ID查找订单信息
	 * @param u_id
	 * @return
	 */
	@Override
	public List<Order> findOrderByUid(int u_id) {
		return userOrderShowMapper.findOrderByUid(u_id);
	}


	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_id
	 * @return
	 */
	
	@Override
	public Order findOrderdetailsByordId(int ord_id) {
		return userOrderShowMapper.findOrderdetailsByordId(ord_id);
	}

}
