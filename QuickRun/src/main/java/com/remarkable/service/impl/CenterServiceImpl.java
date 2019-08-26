package com.remarkable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.User;
import com.remarkable.mapper.CenterMapper;
import com.remarkable.service.ICenterService;

@Service
public class CenterServiceImpl implements ICenterService{
	
	@Autowired
	private CenterMapper centerMapper;

	public void updateUser(User user) {
		centerMapper.updateUser(user);
	}

	public User findUserById(int u_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
