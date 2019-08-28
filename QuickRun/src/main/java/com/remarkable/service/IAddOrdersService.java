package com.remarkable.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.Address;
import com.remarkable.entity.Company;
import com.remarkable.entity.Order;
import com.remarkable.entity.Rectime;

/**
 * 用户发布订单接口
 * @author 王慧
 *
 */
public interface IAddOrdersService {
	
	//用户发布订单
	public void insertOrder(Order order);
	
	//查询快递信息
	List<Company> queryCom();
	
	//查询接收地址信息
	List<Address> queryAdd();
	
	//查询接收时间信息
	List<Rectime> queryTime();

}
