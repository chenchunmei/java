package com.remarkable.service;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Address;

public interface IAddressManagerService {
	
	PageInfo<Address> showAdd(Integer page,Integer pageSize);
	
	int deleteAdd(Integer add_id );
	
	int updateState(Integer add_state,String add_id);

}
