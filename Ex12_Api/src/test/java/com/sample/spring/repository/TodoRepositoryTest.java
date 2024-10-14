package com.sample.spring.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.spring.model.TodoEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;
	
//	@Test
//	public void testInsert() {
//		TodoEntity todo = TodoEntity.builder()
//				.title("title")
//				.writer("writer...")
//				.dueDate(LocalDate.of(2024, 10, 14))
//				.build();
//		
//		TodoEntity result = todoRepository.save(todo);
//		log.info(result);
//	}
	
//	@Test
//	public void testRead() {
//		Long tno = 1L;
//		Optional<TodoEntity> result = todoRepository.findById(tno);
//		TodoEntity todo = result.orElseThrow();
//		log.info("test//////////"+todo);
//		
//	}
	
	@Test
	public void testUpdate() {
		Long tno = 1L;
		Optional<TodoEntity> result = todoRepository.findById(tno);
		TodoEntity todo = result.orElseThrow();
		
		todo.changeTitle("update title");
		todo.changeComplete(true);
		
		todoRepository.save(todo);
	}
	
	
}
