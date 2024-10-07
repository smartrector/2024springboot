package com.sample.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.dao.ISimpleBbsDao;
import com.sample.spring.dto.SimpleBbsDto;

@Service
public class SimpleBbsService implements ISimpleBbsService {

	@Autowired
	ISimpleBbsDao dao;
	
	@Override
	public List<SimpleBbsDto> list() {
		return dao.listDao();
	}

	@Override
	public int count() {
		return dao.countDao();
	}

	@Override
	public SimpleBbsDto view(String id) {
		return dao.viewDao(id);
	}

	@Override
	public int write(String writer, String title, String content) {
		int nResult = dao.writeDao(writer, title, content);
		return nResult;
	}

	@Override
	public int delete(String id) {
		int nResult = dao.delete(id);
		return nResult;
	}
}
