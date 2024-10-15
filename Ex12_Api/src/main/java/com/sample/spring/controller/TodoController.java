package com.sample.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.dto.PageResponseDto;
import com.sample.spring.dto.TodoDto;
import com.sample.spring.service.TodoService;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@Log4j2
@CrossOrigin(origins = "*")
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/{tno}") // http://localhost:8080/api/todo/1
	public TodoDto get(
			@PathVariable(name="tno") Long tno
			) {
		return todoService.get(tno);
	}
	
	@GetMapping("/list")
	public PageResponseDto<TodoDto> list(PageRequestDto pageRequestDto){
		log.info(pageRequestDto);
		
		return todoService.getList(pageRequestDto);
		
	}
	
	@PostMapping("/")
	public Map<String, Long> register(
			@RequestBody TodoDto todoDto
			){
		log.info("todoDto :" + todoDto);
		Long tno = todoService.postTodo(todoDto);
		
		return Map.of("No",tno);
	}
	
	@PutMapping("/{tno}")
	public Map<String, String> modify(
			@PathVariable(name="tno") Long tno,
			@RequestBody TodoDto todoDto
			){
		
		todoDto.setTno(tno);
		
		todoService.modify(todoDto);
		return Map.of("result", "success");
		
	}
	
	@DeleteMapping("/{tno}")
	public Map<String, String> remove(
			@PathVariable(name="tno") Long tno
			){
		todoService.remove(tno);
		return Map.of("result", "success");
	}
	
	
	
}
