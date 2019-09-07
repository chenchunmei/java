package com.remarkable.service;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Order;
import com.remarkable.entity.OrderDatails;
/**
 * 订单管理服务层
 * @author 李明哲
 *
 */
public interface IOrderManagerService {
	
	PageInfo<Order> showOrder(Integer page,Integer pageSize);
	
	PageInfo<Order> selectOrderLike(String ord_code,String ord_rec_name,Integer page,Integer pageSize);
	
	int deleteOrder(String ord_code );
	
	OrderDatails selectDetails(String ord_code);

}
