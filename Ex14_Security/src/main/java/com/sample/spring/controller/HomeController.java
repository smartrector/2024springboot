package com.sample.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@PreAuthorize("hasAnyRole('ROLE_MEMBER')")
	@GetMapping("/test")
	public String testPage() {
		return "test";
	}
}
