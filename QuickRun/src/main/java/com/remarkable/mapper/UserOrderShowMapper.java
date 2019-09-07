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
	 * 根据用户ID,订单编号，订单状态查询订单信息 
	 * @param u_id
	 * @param ord_code
	 * @return
	 */
	List<Order> findOrderByUid(@Param("u_id")int u_id,@Param("ord_code")String ord_code);
	
	
	/**
	 * 根据订单编号查询一个订单详情
	 * @param ord_code 订单编号
	 * @return
	 */
	Order findOrderdetailsByordId(@Param("ord_code") String ord_code);
	
	
	/**
	 * 删除用户订单记录（根据订单编号修改订单状态4）
	 * @param ord_code 订单编号
	 * @return
	 */
	@Update("update tb_order set  ord_state = 4 where ord_code =#{ord_code} and ord_state=5")
	public int deleteUserOrder(String ord_code);
	
	/**
	 * 用户确认完成订单（根据订单编号修改订单状态为5）
	 * @param ord_code 订单编号
	 * @return
	 */
	@Update("update tb_order set  ord_state = 5 where ord_code =#{ord_code}")
	public int overSendOrder(String ord_code);
	
}
