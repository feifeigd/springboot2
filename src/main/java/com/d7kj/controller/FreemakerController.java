package com.d7kj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d7kj.entity.User;
import com.d7kj.service.UserService;

@Controller
@RequestMapping("/freemarker")
public class FreemakerController {
	
	@Autowired UserService userService;
	/***
	 * http://localhost/freemarker/showuser.html?id=1
	 * @param id
	 * @return
	 */
	@GetMapping("/showuser.html")
	public ModelAndView showUserInfo(int id){
		ModelAndView view = new ModelAndView();
		User user = userService.getUserById(id);
		view.addObject("user", user);
		view.setViewName("/userInfo");
		return view;
	}
	
}
