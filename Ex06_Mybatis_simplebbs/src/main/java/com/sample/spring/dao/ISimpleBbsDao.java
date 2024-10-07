package com.sample.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.spring.dto.SimpleBbsDto;


@Mapper
public interface ISimpleBbsDao {
	public List<SimpleBbsDto> listDao();
	public int countDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(String writer,String title, String content);
	public int delete(@Param("_id") String id);   //delete?id=1
}
