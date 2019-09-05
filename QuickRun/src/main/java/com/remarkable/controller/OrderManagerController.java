package com.remarkable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.remarkable.entity.Company;
import com.remarkable.entity.Order;
import com.remarkable.entity.OrderDatails;
import com.remarkable.service.IOrderManagerService;

@Controller
/*@CrossOrigin(origins={"*","null"})*/
public class OrderManagerController {
	
	@Autowired
	private IOrderManagerService ios;
	
	@RequestMapping("orderManage.action")
	public @ResponseBody PageInfo<Order> showTables(String ord_code,String ord_rec_name, Integer page, Integer pageSize){
		PageInfo<Order> pageList=null;
		if(ord_code ==  null && ord_rec_name==null) {
			 pageList = ios.showOrder(page, pageSize);
		}else if(ord_code != null && ord_rec_name != null){
			 pageList = ios.selectOrderLike("%"+ord_code+"%", "%"+ord_rec_name+"%", page, pageSize);
		}		
		return pageList;
	}
	
	@RequestMapping("orderManagedelete.action")
	public String deleteOrder(String ord_code) {
		ios.deleteOrder(ord_code);
		return "orderManage.action";
	}
	
	@RequestMapping("orderDetails.action")
	public @ResponseBody OrderDatails selectDetails(String ord_code) {
		return ios.selectDetails(ord_code);
	}
	

}
