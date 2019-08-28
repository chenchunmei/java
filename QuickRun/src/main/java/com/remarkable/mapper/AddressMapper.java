package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.Address;

/**
 * 地址接口
 * @author Sun
 *
 */
public interface AddressMapper {

	/**
	 * 根据骑手id查询地址
	 * @param emp_id
	 * @return
	 */
	@Select("select add_id,add_detail from tb_address where emp_id = #{emp_id}")
	List<Address> findAddressByEmpId(@Param("emp_id") int emp_id);
}
