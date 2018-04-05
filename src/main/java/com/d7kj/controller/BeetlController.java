package com.d7kj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d7kj.entity.User;
import com.d7kj.service.UserService;

@Controller
@RequestMapping("/beetl")
public class BeetlController {

	@Autowired UserService userService;
	
	@GetMapping("/showuser/{id}.html")
	public ModelAndView showUserInfo(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		User user = userService.getUserById(id);
		view.addObject("user", user);
		view.setViewName("/userInfo.btl");
		return view;
	}
	
	/// 通过方法参数构造 ModelAndView
	@GetMapping("/showuser1/{id}.html")
	public ModelAndView showUserInfo(@PathVariable int id, ModelAndView view) {		
		User user = userService.getUserById(id);
		view.addObject("user", user);
		view.setViewName("/userInfo.html");
		return view;
	}
}
