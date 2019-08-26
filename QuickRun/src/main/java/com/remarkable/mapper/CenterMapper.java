package com.remarkable.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.remarkable.entity.User;

/**
 * 个人中心
 * @author ASUS
 *
 */
@Repository
public interface CenterMapper {
	
	@Insert("insert into tb_user(u_phone,u_nickname,u_sex,u_birthday) "
			+ "values(#{u_phone},#{u_nickname},#{u_sex},#{u_birthday})")
	public void updateUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @return
	 */
	@Select("select u_phone,u_nickname,u_sex,u_birthday from tb_user where u_id=#{u_id}")
	public User findUserById(int u_id);

}
