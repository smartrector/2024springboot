package com.sample.springboot.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_MEMBER')")
	@GetMapping("/api/test")
	public Map<String, Object> testView() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Test message");
        response.put("id", 123);
        return response; // Map 객체가 자동으로 JSON 형식으로 변환됩니다.
    }
}
