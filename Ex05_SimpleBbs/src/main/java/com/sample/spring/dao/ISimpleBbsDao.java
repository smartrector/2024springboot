package com.sample.spring.dao;

import java.util.List;

import com.sample.spring.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
	public List<SimpleBbsDto> listDao();
	public Integer countDao();
	public SimpleBbsDto viewDao(String id);
}
