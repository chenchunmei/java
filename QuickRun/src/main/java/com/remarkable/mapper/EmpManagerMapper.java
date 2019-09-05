package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.Emp;

public interface EmpManagerMapper {
	
	@Select("select * from tb_emp")
	List <Emp> SelectEmp();
	
	@Select("select * from tb_emp "
			+ " where emp_name like #{emp_name} and emp_phone like #{emp_phone} ")
	List<Emp> selectEmpLike(@Param("emp_name") String emp_name,@Param("emp_phone") String emp_phone);
	
	@Delete("delete from tb_emp "
			+ " where emp_id = #{emp_id}")
	int deleteEmp(@Param("emp_id") String emp_id );
	
	@Update("update tb_emp set emp_state =#{emp_state } where emp_id=#{emp_id}")
	int updateState(@Param("emp_state") Integer emp_state ,@Param("emp_id") String emp_id);
	
	@Select("select * from tb_emp where emp_id=#{emp_id}")
	Emp selectEmpById(@Param("emp_id") Integer emp_id);
	
	@Insert ("insert into tb_emp(emp_name,emp_major,emp_dormitory,emp_sno,emp_credit,emp_phone,emp_state) "
			+ " values(#{emp_name},#{emp_major},#{emp_dormitory},#{emp_sno},#{emp_credit},#{emp_phone},#{emp_state})")
	public void insertEmp(Emp emp);
	
	@Update("update tb_emp set emp_name=#{emp_name},emp_major=#{emp_major},emp_dormitory=#{emp_dormitory},emp_sno=#{emp_sno},"
			+ " emp_credit=#{emp_credit},emp_phone=#{emp_phone},emp_state=#{emp_state} "
			+ " where emp_id=#{emp_id}")
	int updateEmp(Emp emp);

}
