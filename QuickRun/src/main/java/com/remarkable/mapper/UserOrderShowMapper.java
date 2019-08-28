package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.remarkable.entity.Company;
import com.remarkable.entity.Order;

/**
 * 用户订单显示
 * @author 王慧
 *
 */
@Repository
public interface UserOrderShowMapper {
	
	/**
	 * 根据用户ID和订单状态查询订单信息 连表
	 * @return
	 */
	List<Order> findOrderByUid(@Param("u_id")int u_id);
	
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_id
	 * @return
	 */
	Order findOrderdetailsByordId(@Param("ord_id") int ord_id);
	
	
	/**
	 * 删除用户订单记录（根据订单ID修改订单状态）
	 */
	@Update("update tb_order set  ord_state = 4 where ord_id =#{ord_id}")
	public int deleteUserOrder(int ord_id);
	
	
}
