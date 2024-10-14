package com.sample.spring.repository;

import java.time.LocalDate;

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
	
	@Test
	public void testInsert() {
		TodoEntity todo = TodoEntity.builder()
				.title("title")
				.writer("writer...")
				.dueDate(LocalDate.of(2024, 10, 14))
				.build();
		
		TodoEntity result = todoRepository.save(todo);
		log.info(result);
	}
}
