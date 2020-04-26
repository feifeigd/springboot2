package com.d7kj.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.annotation.Function;

@Controller
public class HelloworldController {

	Log log = LogFactory.getLog(HelloworldController.class);

	/// 测试使用模板引擎Beetl
	/// Model用于参数的时候, SpringMVC框架在调用方法前自动创建Model
	@RequestMapping("/index.html")
	public String index(Model model) {
		log.debug("HelloworldController/index");
		model.addAttribute("name", "hello, world");
		return "/index.html";	// 返回模板路径
	}
	
	@RequestMapping("/say.html")
	// 反回文本
	public @ResponseBody String say() {
		return "Hello Spring Boot";
	}
	
	// http://127.0.0.1:8080/sayhello.html?name=springboot
	@RequestMapping("/sayhello.html")
	@Function("")
	public @ResponseBody String say(String name){
		return "hello "+name;
	}
	
	@GetMapping(path="/update.json", params="action=save")
	public void saveUser(){
		System.out.println("call save");
	}
}
