package com.sample.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.spring.domain.Member;
import com.sample.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "test";
	}
	
	@RequestMapping("/all")
	public String selectAll(Model model) {
		List<Member> result =  memberService.selectAll();
		model.addAttribute("members", result);
		return "selectAll";
	}
}
