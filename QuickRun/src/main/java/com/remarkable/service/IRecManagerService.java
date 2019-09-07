package com.remarkable.service;

import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.entity.Rectime;
/**
 * 接收时间管理服务层
 * @author 李明哲
 *
 */
public interface IRecManagerService {
	
	PageInfo<Rectime> showRec(Integer page,Integer pageSize);
		
	int deleteRec(Integer rec_id );
	
	int updateState(Integer rec_state,String rec_id);
	
	public void insertRec(Rectime rectime);

}
