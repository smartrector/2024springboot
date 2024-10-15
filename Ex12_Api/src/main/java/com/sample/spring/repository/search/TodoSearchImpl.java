package com.sample.spring.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.sample.spring.model.TodoEntity;

public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch{

	public TodoSearchImpl() {
		super(TodoEntity.class);
	}

	@Override
	public Page<TodoEntity> search1() {
		return null;
	}

	
}
