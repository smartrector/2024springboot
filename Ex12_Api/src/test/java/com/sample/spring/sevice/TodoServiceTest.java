package com.sample.spring.sevice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.dto.PageResponseDto;
import com.sample.spring.dto.TodoDto;
import com.sample.spring.model.TodoEntity;
import com.sample.spring.service.TodoService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTest {
	
	@Autowired
	TodoService todoSevice;
	
	@Test
	public void testList() {
		PageRequestDto pageRequestDto = PageRequestDto.builder()
				.page(1)
				.size(10)
				.build();
		
		PageResponseDto<TodoDto> response = todoSevice.getList(pageRequestDto);
		
		log.info(response);
	}
}
