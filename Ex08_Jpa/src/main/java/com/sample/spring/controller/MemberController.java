package com.sample.spring.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam("id") Long id
			) {
		
		memberService.delete(id);
		
		return "delete";
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(
			@RequestParam("name") String search,
			@RequestParam("page") String page,
			Model model
			) {
		
		System.out.println("/--------------- "+search+" --------------/");
		System.out.println("/--------------- "+page+" --------------/");
		
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int nPage = Integer.parseInt(page) - 1;
		
		Pageable pageable = PageRequest.ofSize(10)
				.withPage(nPage)
				.withSort(sort);
		
		
		Page<Member> result = memberService.selectNameLike(name, pageable);
        List<Member> content = result.getContent();
        long totalElements = result.getTotalElements();
        int  totalPages    = result.getTotalPages();
        int  size          = result.getSize();
        int  pageNumber    = result.getNumber() + 1;	// 0부터 시작하므로
        int  numberOfElements = result.getNumberOfElements(); // content의 개수

    	model.addAttribute("members", content);
    	model.addAttribute("totalElements", totalElements);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("size", size);
    	model.addAttribute("pageNumber", pageNumber);
    	model.addAttribute("numberOfElements", numberOfElements);
		
		
		return "selectList";
	}
	
	
}
