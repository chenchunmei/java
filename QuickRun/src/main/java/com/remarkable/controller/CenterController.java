package com.remarkable.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;
import com.remarkable.service.ICenterService;
import com.remarkable.service.impl.CenterServiceImpl;

@Controller
@CrossOrigin(origins={"*","null"})
public class CenterController {
	
	@Autowired
	private ICenterService centerServiceImpl;

	@RequestMapping("/updateUser.action")
	@ResponseBody
	public Integer updateUser(User user,HttpServletResponse res) {
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		user.setU_id(1);
		Integer count = centerServiceImpl.updateUser(user);
		return count;
	}
	
	@RequestMapping("/uploadImage.action")
	public @ResponseBody HashMap<String, Object> uploadImage(Model model,MultipartFile file,HttpServletRequest request){
		//获取文件名
		String fileName = file.getOriginalFilename();
		//截取字符串
		String subFileName = fileName.substring(fileName.lastIndexOf(File.separatorChar) + 1);
		String newFileName = System.currentTimeMillis() + (new Random().nextInt(8999) + 1000) + subFileName;
		
		//创建需要存储文件的文件夹的名字
		String uuid= UUID.randomUUID().toString().replace("-","");
		
		//获取服务器的真实路径
		String realPath = request.getServletContext().getRealPath("/uploads/");
		String path=request.getServletContext().getContextPath();
		System.err.println(path);
		
		//获取文件上传的真实路径
		String realFileName = realPath + "\\" + uuid +newFileName;
		//判断文件存储的路径是否存在
		File uploadFile = new File(realFileName);
		
		//用于返回状态的json格式
		HashMap<String, Object> map = new HashMap<String,Object>();
		//上传文件
		try{
			file.transferTo(uploadFile);
			map.put("code", 0);
			map.put("msg", uuid + "/" +newFileName);
			HashMap<String, Object> dataMap =new HashMap<String,Object>();
			dataMap.put("src", uuid + "/" +newFileName);
			map.put("data",dataMap);
			Images images = new Images();
			images.setIma_address(realFileName);
			images.setU_id(1);
			System.out.println(map.get("data"));
			centerServiceImpl.judgeInsertImages(images, 1);
		}catch(Exception e){
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/showUser.action")
	public @ResponseBody Images showUser(HttpServletRequest request){
		int u_id =1;
		Images images=centerServiceImpl.findImagesByid(u_id);
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(images);
		return images;
	}
	
	@RequestMapping("/showEmp")
	@ResponseBody
	public Emp showEmp(){
		int emp_id = 1;
		Emp emp = centerServiceImpl.findEmpById(emp_id);
		System.out.println(emp);
		return emp;
	}
	
	@RequestMapping("/updateEmp")
	@ResponseBody
	public int updateEmp(Emp emp){
		emp.setEmp_id(1);
		System.out.println("================="+emp);
		int count= centerServiceImpl.updateEmp(emp);
		System.out.println(count);
		return count;
		
	}
	
	@RequestMapping("/insertComplaint")
	@ResponseBody
	public Integer insertComplaint(String ord_complaint,String ord_code,HttpServletResponse res){
		res.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("=========================================");
		System.out.println(ord_complaint);
		Integer emp_id =1;
		return centerServiceImpl.insertCompaint(ord_complaint, ord_code,emp_id);
	}
}
