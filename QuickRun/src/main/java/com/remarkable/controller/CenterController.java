package com.remarkable.controller;

import java.io.File;
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

import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;
import com.remarkable.service.ICenterService;

/**
 * 个人中心的控器类
 * @author 陈春妹
 *
 */
@Controller
@CrossOrigin(origins={"*","null"})
public class CenterController {
	
	//用户中心service层的对象
	@Autowired
	private ICenterService centerServiceImpl;

	//修改用户信息
	@RequestMapping("/updateUser.action")
	@ResponseBody
	public Integer updateUser(User user) {
		//设置跨域问题可以允许跨域
		Integer count = centerServiceImpl.updateUser(user);
		//返回是否修改成功
		return count;
	}
	
	/**
	 * 上传用户头像
	 * @param model 返回结果
	 * @param file 上传头像的工具
	 * @param request
	 * @return
	 */
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
			//===============
			int u_id = Integer.parseInt(request.getParameter("u_id"));
			images.setU_id(u_id);
			//调用service层上传图片的方法
			centerServiceImpl.judgeInsertImages(images, 1);
		}catch(Exception e){
			//上传失败
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据用户id显示用户信息
	 * @param request
	 * @return 返回images对象
	 */
	@RequestMapping("/showUser.action")
	public @ResponseBody Images showUser(HttpServletRequest request){
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		Images images=centerServiceImpl.findImagesByid(u_id);
		return images;
	}
	
	/**
	 * 显示员工的信息
	 * @return
	 */
	@RequestMapping("/showEmp")
	@ResponseBody
	public Emp showEmp(HttpServletRequest request){
		int emp_id = (int) request.getSession().getAttribute("emp_id");
		Emp emp = centerServiceImpl.findEmpById(emp_id);
		System.out.println(emp);
		return emp;
	}
	
	/**
	 * 修改员工的信息
	 * @param emp 员工
	 * @return
	 */
	@RequestMapping("/updateEmp")
	@ResponseBody
	public int updateEmp(Emp emp,HttpServletRequest request){
		int emp_id = (int) request.getSession().getAttribute("emp_id");
		emp.setEmp_id(emp_id);
		System.out.println("================="+emp);
		int count= centerServiceImpl.updateEmp(emp);
		System.out.println(count);
		return count;
		
	}
	
	/**
	 * 用户投诉信息
	 * @param ord_complaint 投诉信息
	 * @param ord_code 订单编号
	 * @param res
	 * @return
	 */
	@RequestMapping("/insertComplaint")
	@ResponseBody
	public Integer insertComplaint(String ord_complaint,String ord_code,HttpServletResponse res,HttpServletRequest request){
		//res.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(ord_complaint);
		int emp_id = (int) request.getSession().getAttribute("emp_id");
		return centerServiceImpl.insertCompaint(ord_complaint, ord_code,emp_id);
	}
}
