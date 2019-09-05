package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.User;

public interface UserManagerMapper {
	
	@Select("select * from tb_user")
	List <User> SelectUser();
	
	@Select("select * from tb_user "
			+ " where u_phone like #{u_phone} and u_nickname like #{u_nickname} ")
	List<User> selectUserLike(@Param("u_phone") String u_phone,@Param("u_nickname") String u_nickname);
	
	@Delete("delete from tb_user "
			+ " where u_id  = #{u_id}")
	int deleteUser(@Param("u_id") Integer u_id);
	
	@Update("update tb_user set u_state=#{u_state} where u_id=#{u_id}")
	int updateState(@Param("u_state") Integer u_state ,@Param("u_id") String u_id);
}
