package com.d7kj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {
	
	@RequestMapping("/say.html")
	// 反回文本
	public @ResponseBody String say() {
		return "Hello Spring Boot";
	}
	// http://127.0.0.1:8080/sayhello.html?name=springboot
	@RequestMapping("/sayhello.html")
	public @ResponseBody String say(String name){
		return "hello "+name;
	}
}
