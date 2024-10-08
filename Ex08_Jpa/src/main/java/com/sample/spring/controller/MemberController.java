package com.sample.spring.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/insert") // insert?name= &email=
	public String insert(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			Model model) {
		Member member = Member.builder()
				.name(name)
				.email(email)
				.createDate(LocalDate.now())
				.build();
		Member result = memberService.insert(member);
		model.addAttribute("member", result);
		return "insert";
	}
	
	@RequestMapping("/view") // view?id=
	public String view(
			@RequestParam("id") Long id,
			Model model
			) {
		Optional<Member> result = memberService.view(id);
		
		
		
		if(result.isPresent()) {
			model.addAttribute("member", result.get());
		}else {
			model.addAttribute("member", null);
		}
		return "view";
	}
	
}
