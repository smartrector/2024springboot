package com.sample.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		
		mv.setViewName("view/mv");
		
		return mv;
	}
}
