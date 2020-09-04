package com.d7kj.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.entity.User;
import com.d7kj.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	/// 自动注入bean
	@Autowired UserService userService;
	
	@RequestMapping("/index.json")
	public @ResponseBody String say() {
		return "ffffffffffff";
	}
	
	/// 返回json格式
	@GetMapping("/all.json")
	public @ResponseBody List<User> allUser(){
		return userService.allUser();
	}
	
	/// 返回json格式
	/// 通过配置文件或者环境变量
	@GetMapping("/${query.all}.json")
	public @ResponseBody List<User> all(){
		return userService.allUser();
	}
	
	/// 返回json格式
	@GetMapping("/get/{id}.json")
	public @ResponseBody User getById(@PathVariable int id){
		return userService.getUserById(id);
	}

	@GetMapping
	public Object test(){
		return Collections.singletonMap("success", true);
	}
}
