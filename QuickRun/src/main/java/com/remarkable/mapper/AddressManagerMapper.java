package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.Address;

public interface AddressManagerMapper {
	
	@Select("select * from tb_address")
	List <Address> SelectAdd();
	
	@Delete("delete from  tb_address "
			+ " where add_id  = #{add_id}")
	int deleteAdd(@Param("add_id") Integer add_id);
	
	@Update("update  tb_address set add_state=#{add_state} where add_id=#{add_id}")
	int updateState(@Param("add_state") Integer add_state ,@Param("add_id") String add_id);

}
