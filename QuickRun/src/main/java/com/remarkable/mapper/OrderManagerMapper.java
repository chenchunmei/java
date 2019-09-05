package com.remarkable.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.remarkable.entity.Order;
import com.remarkable.entity.OrderDatails;

public interface OrderManagerMapper {
	
	@Select("select ord_code,ord_send_time,ord_pick_code,Ord_phone,ord_rec_name, "
			+ " ord_wight,ord_state from tb_order")
	List <Order> SelectOrder();
	
	@Select("select ord_code,ord_send_time,ord_pick_code,Ord_phone,ord_rec_name, "
			+ " ord_wight,ord_state from tb_order "
			+ " where ord_code like #{ord_code} and ord_rec_name like #{ord_rec_name}")
	List<Order> selectOrderLike(@Param("ord_code") String ord_code,@Param("ord_rec_name") String ord_rec_name);
	
	@Delete("delete from tb_order "
			+ " where ord_code = #{ord_code}")
	int deleteOrder(@Param("ord_code") String ord_code );
	
	@Update("update tb_company set add_state=#{add_state} where com_id=#{com_id}")
	int updateState(@Param("add_state") Integer add_state ,@Param("com_id") String com_id);
	
	@Select("select ta.add_detail,tc.com_name,te.emp_name,tu.u_nickname,tr.rec_detail from tb_order tb "
			+ " left join tb_company tc on tc.com_id =tb.com_id "
			+ " left join tb_rec tr on tr.rec_id = tb.rec_id "
			+ " left join tb_address ta on ta.add_id = tb.add_id "
			+ " left join tb_user tu on tu.u_id = tb.u_id "
			+ " left join tb_emp te on te.emp_id = tb.emp_id "
			+ " where ord_code = #{ord_code}")
	OrderDatails selectDetails(@Param("ord_code") String order_code);

}
