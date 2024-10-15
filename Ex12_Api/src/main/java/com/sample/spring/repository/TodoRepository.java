package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.model.TodoEntity;
import com.sample.spring.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>, TodoSearch {

}
