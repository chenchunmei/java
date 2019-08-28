package com.remarkable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.remarkable.entity.Address;
import com.remarkable.entity.Emp;
import com.remarkable.service.IAddressService;

/**
 * 地址控制层
 * @author Sun
 *
 */
@Controller
@CrossOrigin(origins = {"*", "null"})
public class AddressController {

	//调用地址服务层
	@Autowired
	private IAddressService addressServiceImpl;
	
	/**
	 * 根据骑手id查询地址
	 * @param emp_id
	 * @return
	 */
	@RequestMapping("/addressEmp.action")
	public @ResponseBody List<Address> findAddressByEmpId(Emp emp){
		emp.setEmp_id(1);
		List<Address> addressList = addressServiceImpl.findAddressByEmpId(emp.getEmp_id());
		return addressList;
	}
}
