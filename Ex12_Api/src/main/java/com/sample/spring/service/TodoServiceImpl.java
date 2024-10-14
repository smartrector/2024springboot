package com.sample.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.dto.TodoDto;
import com.sample.spring.model.TodoEntity;
import com.sample.spring.repository.TodoRepository;


@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public TodoDto get(Long tno) {
		
		Optional<TodoEntity> result = todoRepository.findById(tno);
		TodoEntity todo = result.orElseThrow();

		return entityToDto(todo);
	}

	@Override
	public Long postTodo(TodoDto dto) {
		TodoEntity todo = dtoToEntity(dto);
		TodoEntity result = todoRepository.save(todo);
		
		return result.getTno();
	}

	@Override
	public void modify(TodoDto dto) {
		Optional<TodoEntity> result = todoRepository.findById(dto.getTno());
		TodoEntity todo = result.orElseThrow();
		
		todo.changeTitle(dto.getTitle());
		todo.changeComplete(dto.isComplete());
		todo.changeDueDate(dto.getDueDate());
		
		todoRepository.save(todo);
		
	}

	@Override
	public void remove(Long tno) {
		todoRepository.deleteById(tno);
	}
	
	

}
