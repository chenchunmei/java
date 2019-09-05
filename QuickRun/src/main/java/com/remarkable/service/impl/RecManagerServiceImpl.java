package com.remarkable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Rectime;
import com.remarkable.mapper.RecManagerMapper;
import com.remarkable.service.IRecManagerService;

@Service
public class RecManagerServiceImpl implements IRecManagerService {

	@Autowired
	private RecManagerMapper rmm;
	
	@Override
	public PageInfo<Rectime> showRec(Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 3: pageSize;
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Rectime> list =rmm.SelectRec();			
		PageInfo<Rectime> pageList = new PageInfo<Rectime>(list);
		return pageList;
	}

	@Override
	public int deleteRec(Integer rec_id) {
		return rmm.deleteRec(rec_id);
	}

	@Override
	public int updateState(Integer rec_state, String rec_id) {
		return rmm.updateState(rec_state, rec_id);
	}

}
