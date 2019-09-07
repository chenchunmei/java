package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.entity.User;
import com.remarkable.mapper.UserManagerMapper;
import com.remarkable.service.IUserManagerService;
/**
 * 用户管理接口实现层
 * @author 李明哲
 *
 */
@Service
public class UserManagerServiceImpl implements IUserManagerService{
	
	@Autowired
	private UserManagerMapper umm;

	@Override
	public PageInfo<User> showUser(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<User> list = umm.SelectUser();			
		PageInfo<User> pageList = new PageInfo<User>(list);
		return pageList;
	}

	@Override
	public PageInfo<User> selectUserLike(String u_phone, String u_nickname, Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<User> list =umm.selectUserLike("%"+u_phone+"%", "%"+u_nickname+"%");
		PageInfo<User> pageList = new PageInfo<User>(list);
		return pageList;
	}

	@Override
	public int deleteUser(Integer u_id) {
		return umm.deleteUser(u_id);
	}

	@Override
	public int updateState(Integer u_state, String u_id) {
		return umm.updateState(u_state, u_id);
	}

}
