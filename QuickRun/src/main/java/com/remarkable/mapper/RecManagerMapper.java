package com.remarkable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.remarkable.entity.Company;
import com.remarkable.entity.Rectime;

public interface RecManagerMapper {
	
	@Select("select * from tb_rec")
	List <Rectime> SelectRec();
	
	@Delete("delete from tb_rec "
			+ " where rec_id  = #{rec_id}")
	int deleteRec(@Param("rec_id") Integer rec_id);
	
	@Update("update tb_rec set rec_state=#{rec_state} where rec_id=#{rec_id}")
	int updateState(@Param("rec_state") Integer rec_state ,@Param("rec_id") String rec_id);
	
	@Insert ("insert into tb_rec(rec_detail,rec_state) "
			+ " values(#{rec_detail},#{rec_state})")
	public void insertRec(Rectime rectime);

}
