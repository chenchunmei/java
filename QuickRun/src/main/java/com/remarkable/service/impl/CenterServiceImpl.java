package com.remarkable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;
import com.remarkable.mapper.CenterMapper;
import com.remarkable.service.ICenterService;

/**
 * 个人中心的业务层实现类
 * @author 陈春妹
 *
 */
@Service
public class CenterServiceImpl implements ICenterService{
	
	//个人中心的mapper
	@Autowired
	private CenterMapper centerMapper;

	/**
	 * 修改用户信息
	 * @param user
	 */
	public Integer updateUser(User user) {
		return centerMapper.updateUser(user);
	}

	/**
	 * 根据用户名查找用户信息
	 * @param u_id
	 * @return
	 */
	public User findUserById(int u_id) {
		User user = centerMapper.findUserById(u_id);
		return user;
	}


	/**
	 * 根据员工id查询员工信息
	 * @param emp_id
	 * @return
	 */
	public Emp findEmpById(Integer emp_id) {
		Emp emp = centerMapper.findEmpById(emp_id);
		return emp;
	}

	/**
	 * 根据员工id修改员工信息
	 * @param emp
	 * @return
	 */
	public int updateEmp(Emp emp) {
		int count = centerMapper.updateEmp(emp);
		return count;
	}

	/**
	 * 添加头像
	 * @param images
	 * @return
	 */
	public Integer insertImages(Images images,Integer u_id) {
		images.setU_id(u_id);
		return centerMapper.insertImages(images);
	}

	/**
	 * 根据用户id 查找用户头像
	 * @param u_id
	 * @return
	 */
	public Images findImagesByid(Integer u_id) {
		//第一次查找有没有该用户的头像
		Images images = new Images();
		Images img=centerMapper.findImagesByid(u_id);
		//设置默认的头像路径
		String imagesPath="D:\\Workspaces\\maven_1711\\QuickRun\\src\\main\\webapp\\uploads\\default.gif";
		//没有头像则先添加一个默认的头像
		if(img == null ){
			images.setU_id(u_id);
			images.setIma_address(imagesPath);
			//添加头像
			centerMapper.insertImages(images);
			//再次查询头像并返回
			img=centerMapper.findImagesByid(u_id);
		}
		return img;
	}
	/**
	 * 根据订单编号投诉
	 * @param ord_complaint 投诉信息
	 * @param ord_code 订单编号
	 * @return
	 */
	public Integer insertCompaint(String ord_complaint, String ord_code,Integer emp_id) {
		findComplaintCount(emp_id);
		return centerMapper.insertCompaint(ord_complaint, ord_code);
	}

	/**
	 * 查询投诉信息的总记录
	 * @param ord_code
	 * @return
	 */
	public boolean findComplaintCount(Integer emp_id) {
		//调用该用户被投诉次数的方法
		Integer count = centerMapper.findComplaintCount(emp_id);
		
		//用户判断是否进行减信誉值，大于3减，返回true,否则false
		boolean isRun = false;
		//如果该员工投诉次数超过三次，则信誉值
		if(count > 3){

			centerMapper.reduceEmpCredit(emp_id);
			isRun = true;
		}
		return isRun;
	}

	/**
	 * 根据用户id来判断是否要添加头像还是修改头像
	 * @param images 
	 * @param u_id
	 */
	public void judgeInsertImages(Images images, Integer u_id) {
		images.setU_id(u_id);
		//查看是否当前用户是否有头像，有则修改，无则添加
		Integer result=centerMapper.findImageByU_Id(u_id);
		
		if(result == 0){
			//添加头像
			centerMapper.insertImages(images);
		}else{
			//修改头像
			centerMapper.updateImages(images);
		}
	}
}
