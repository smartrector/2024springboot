package com.sample.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "jsp test";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "sub/test1";
	}
	
	@RequestMapping("/model")
	public String model(Model model) {
		model.addAttribute("name","홍길동");
		return "model";
	}
	
	
	@RequestMapping("/mv")
	public ModelAndView mv2() {
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists",list);
		mv.addObject("name","홍길동");
		
		mv.setViewName("view/mv");
		
		return mv;
	}
	
	
	@RequestMapping("/index") //index?name=한성용
	public String index(HttpServletRequest request,Model model ) {
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		
		model.addAttribute("name", name);
		model.addAttribute("nickname", nickname);
		return "index";
	}
	
	@RequestMapping("/view1")
	public String view1(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			Model model
			) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "view1";
	}
	
	
	@RequestMapping("/view2")
	public String view2(
			MemberDto member,
			Model model
			) {
		
		model.addAttribute("id",member.getId());
		model.addAttribute("name",member.getName());
		
		return "view2";
	}
	
	@RequestMapping("/view3/{id}/{name}")
	public String view3(
			@PathVariable("studentId") String studentId,
			@PathVariable("name") String name,
			Model model
			) {
		
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		
		return "view3";
	}
	
	
}
