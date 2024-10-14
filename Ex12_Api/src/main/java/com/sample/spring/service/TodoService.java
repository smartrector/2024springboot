package com.sample.spring.service;

import com.sample.spring.dto.TodoDto;
import com.sample.spring.model.TodoEntity;

public interface TodoService {
	public TodoDto get(Long tno);
	
	public Long postTodo(TodoDto dto);
	
	public void modify(TodoDto dto);
	public void remove(Long tno);
	
	
	default TodoDto entityToDto(TodoEntity todo) {
		TodoDto todoDto = TodoDto.builder()
				.tno(todo.getTno())
				.title(todo.getTitle())
				.write(todo.getWriter())
				.complete(todo.isComplete())
				.dueDate(todo.getDueDate())
				.build();
		return todoDto;
	}
	
	default TodoEntity dtoToEntity(TodoDto todoDto) {
		TodoEntity todoEntity = TodoEntity.builder()
				.tno(todoDto.getTno())
				.title(todoDto.getTitle())
				.writer(todoDto.getWrite())
				.complete(todoDto.isComplete())
				.dueDate(todoDto.getDueDate())
				.build();
		return todoEntity;
	}
}
