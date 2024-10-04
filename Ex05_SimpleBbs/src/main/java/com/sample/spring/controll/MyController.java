package com.sample.spring.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.spring.dao.ISimpleBbsDao;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	
	@RequestMapping("/")
	public  String root() {
		return "redirect:list";
	}
	
}
