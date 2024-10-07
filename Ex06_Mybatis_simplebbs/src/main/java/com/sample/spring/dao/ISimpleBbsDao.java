package com.sample.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.spring.dto.SimpleBbsDto;


@Mapper
public interface ISimpleBbsDao {
	public List<SimpleBbsDto> listDao();
	public Integer countDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(String writer,String title, String content);
	public int delete(String id);   //delete?id=1
}
