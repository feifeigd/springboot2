package com.d7kj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.service.UserService;

@Controller
@RequestMapping("/modelattribute")
public class ModelAttributeController {

	@Autowired UserService userService;
	
	/// Controller方法中的公共放啊，调用方法前先调用此方法。
	@ModelAttribute
	public void findUserById(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
	}
	
	@GetMapping("{id}/get.json")
	@ResponseBody
	public String getUser(Model model) {
		System.out.println(model.containsAttribute("user"));
		return "success";
	}
}
