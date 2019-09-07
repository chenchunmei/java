package com.remarkable.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.remarkable.entity.Company;

public interface CompanyManagerMapper {
	
	@Select("select * from tb_company")
	List <Company> SelectCompany();
	
	@Select("select * from tb_company "
			+ " where com_name like #{com_name} ")
	List<Company> selectCompanyLike(@Param("com_name") String com_name);
	
	@Delete("delete from tb_company "
			+ " where com_id = #{com_id}")
	int deletecompany(@Param("com_id") Integer com_id );
	
	@Update("update tb_company set com_state=#{com_state} where com_id=#{com_id}")
	int updateState(@Param("com_state") Integer com_state ,@Param("com_id") String com_id);
	
	@Select("select * from tb_company where com_id=#{com_id}")
	Company selectCompanyById(@Param("com_id") Integer com_id);
	
	@Insert ("insert into tb_company(com_name,com_content,com_state) "
			+ " values(#{com_name},#{com_content},#{com_state})")
	public void insertCompany(Company company);
	
	@Update("update tb_company set com_name=#{com_name},com_content=#{com_content},com_state=#{com_state} "
			+ " where com_id=#{com_id}")
	int updateCompany(Company company);

}
