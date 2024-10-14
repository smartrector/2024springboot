package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.model.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
