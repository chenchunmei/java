package com.remarkable.service;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.User;
/**
 * 用户管理服务层
 * @author 李明哲
 *
 */
public interface IUserManagerService {
	
	PageInfo<User> showUser(Integer page,Integer pageSize);
	
	PageInfo<User> selectUserLike(String u_phone,String u_nickname,Integer page,Integer pageSize);
	
	int deleteUser(Integer u_id );
	
	int updateState(Integer u_state,String u_id);
	
}
