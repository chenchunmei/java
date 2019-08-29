package com.remarkable.mapper;

import java.awt.Image;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.remarkable.entity.Emp;
import com.remarkable.entity.Images;
import com.remarkable.entity.User;

/**
 * 个人中心持久层接口
 * @author 陈春妹
 *
 */
@Repository
public interface CenterMapper {
	
	/**
	 * 修改用户的对象信息
	 * @param user 用户对象
	 * @return
	 */
	@Update("update tb_user set u_phone=#{u_phone},u_nickname=#{u_nickname},u_sex=#{u_sex},u_birthday=#{u_birthday} where u_id = #{u_id}")
	public Integer updateUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @return
	 */
	@Select("select * from tb_user where u_id=#{u_id}")
	public User findUserById(int u_id);
	
	
	/**
	 * 根据用户id查找用户信息，images里面放用户对象
	 * @param u_id 用户id
	 * @return
	 */
	@Select("select * from tb_images where u_id=#{u_id}")
	@Results(value={
			@Result(column="ima_id",property="ima_id",id=true),
			@Result(column="ima_address",property="ima_address"),
			@Result(column="u_id",property="user",
			one=@One(select="com.remarkable.mapper.CenterMapper.findUserById")
			),
	})
	public Images findImagesByid(Integer u_id);
	
	/**
	 * 根据员工id查询员工信息
	 * @param emp_id
	 * @return
	 */
	@Select("select * from tb_emp where emp_id = #{emp_id}")
	public Emp findEmpById(Integer emp_id);
	
	/**
	 * 根据员工id修改员工信息
	 * @param emp
	 * @return
	 */
	@Update("update tb_emp set emp_dormitory = #{emp_dormitory}, emp_phone = #{emp_phone} where emp_id =#{emp_id}")
	public int updateEmp(Emp emp);
	
	/**
	 * 添加头像
	 * @return
	 */
	@Insert("insert into tb_images(ima_address,u_id) values(#{ima_address},#{u_id})")
	public Integer insertImages(Images images); 
	
	/**
	 * 根据订单编号投诉
	 * @param u_code
	 * @param ord_complaint
	 * @return
	 */
	@Update("update tb_order set ord_complaint = #{ord_complaint} where ord_code =#{ord_code}")
	public Integer insertCompaint(@Param("ord_complaint")String ord_complaint,@Param("ord_code")String ord_code);
	
	/**
	 * 查询投诉信息的总记录
	 * @param ord_code
	 * @return
	 */
	@Select("SELECT COUNT(ord_complaint) num FROM tb_order WHERE ord_complaint IS NOT NULL AND emp_id= #{emp_id}")
	public Integer findComplaintCount(@Param("emp_id")Integer emp_id);
	
	/**
	 * 当投诉次数大于三次以上，则骑手的信用值减1
	 * @param emp_id 骑手id
	 * @return
	 */
	@Update("UPDATE tb_emp SET emp_credit=(emp_credit-1) WHERE emp_id =#{emp_id}")
	public int reduceEmpCredit(Integer emp_id);
	
	/**
	 * 根据用户的id查找头像
	 * @param u_id
	 * @return
	 */
	@Select("SELECT COUNT(ima_address) FROM tb_images WHERE ima_address IS NOT NULL AND u_id=#{u_id}")
	public Integer findImageByU_Id(Integer u_id);
	
	/**
	 * 修改用户头像
	 * @param images 
	 * @return
	 */
	@Update("update tb_images set ima_address = #{ima_address} where u_id =#{u_id}")
	public Integer updateImages(Images images);
}
