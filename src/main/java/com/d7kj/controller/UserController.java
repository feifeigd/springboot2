package com.d7kj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d7kj.entity.User;
import com.d7kj.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/queryUser.html")
	public ModelAndView queryUsers(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user.html#userPage");
		List<User> users = userService.allUser();
		view.addObject("userList", users);
		return view;
		//request.setAttribute("userList", users);
		//return "/user.html#userPage";
	}
}
