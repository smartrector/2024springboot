package com.sample.spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/hello")
	public String hello() {
		return "get-hello";
	}
	
	@PostMapping("/hello")
	public String posthello() {
		return "post-hello";
	}
	
	@PutMapping("/hello")
	public String puthello() {
		return "put-hello";
	}
	
	@DeleteMapping("/hello")
	public String deletehello() {
		return "delete-hello";
	}
	
	
	@GetMapping("/test/param") //param?name=&age=
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age
			) {
		
		return "hello, request param, i am " + name+ ", "+ age;
	}
	
	@GetMapping("/test/path/{name}/{age}")
	public String requestPathVariable(
			@PathVariable("name") String name,
			@PathVariable("age") Integer age
			) {
		
		return "hello, request path, i am " + name+ ", "+ age;
	}
	
	@PostMapping("/test")
	public  String requestBody(
			@RequestBody RequestDto request
			) {
		return "hello, request body, i am " + request.getName()+ ", "+ request.getAge();
	}
}
