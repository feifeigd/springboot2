package com.d7kj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/test.html")
	public ModelAndView test() {
		ModelAndView view = new ModelAndView("/test.html");
		return view;
	}
}
