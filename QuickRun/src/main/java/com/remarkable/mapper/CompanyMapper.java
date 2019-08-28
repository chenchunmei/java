package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.remarkable.entity.Company;

/**
 * 公司接口
 * @author Sun
 *
 */
public interface CompanyMapper {

	/**
	 * 查询所有公司
	 * @return
	 */
	@Select("select com_id,com_name from tb_company")
	List<Company> findCompanyAll();
}
