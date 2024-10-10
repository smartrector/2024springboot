package com.sample.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.entity.TestEntity;
import com.sample.spring.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public void create(String name,Integer age) {
		TestEntity testEntity = new TestEntity(name,age);
		testRepository.save(testEntity);
	}
	
	public void update(Long id,String name,Integer age) {
		 TestEntity testEntity= testRepository.findById(id).get();
		 testEntity.changeNameAndAge(name, age);
		 testRepository.save(testEntity);
	}
}
