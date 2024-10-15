package com.sample.spring.repository.search;

import org.springframework.data.domain.Page;

import com.sample.spring.model.TodoEntity;

public interface TodoSearch {
	Page<TodoEntity> search1();
}
