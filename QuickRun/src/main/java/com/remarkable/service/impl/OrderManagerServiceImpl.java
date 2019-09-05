package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Order;
import com.remarkable.entity.OrderDatails;
import com.remarkable.mapper.OrderManagerMapper;
import com.remarkable.service.IOrderManagerService;

@Service
public class OrderManagerServiceImpl implements IOrderManagerService {
	
	@Autowired
	private OrderManagerMapper omm;

	@Override
	public PageInfo<Order> showOrder(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Order> list = omm.SelectOrder();		
		PageInfo<Order> pageList = new PageInfo<Order>(list);
		return pageList;
	}

	@Override
	public PageInfo<Order> selectOrderLike(String ord_code, String ord_rec_name, Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Order> list =omm.selectOrderLike("%"+ord_code+"%", "%"+ord_rec_name+"%");
		PageInfo<Order> pageList = new PageInfo<Order>(list);
		return pageList;
	}

	@Override
	public int deleteOrder(String ord_code) {
		return omm.deleteOrder(ord_code);
	}

	@Override
	public OrderDatails selectDetails(String ord_code) {
		return omm.selectDetails(ord_code);
	}

}
