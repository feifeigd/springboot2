package com.d7kj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.controller.form.OrderPostForm;
import com.d7kj.entity.User;
import com.d7kj.service.UserService;

@Controller
@RequestMapping("/javabean")
public class JavaBeanController {
	
	@Autowired UserService userService;

	/// http://localhost/javabean/update.json?id=1&name=fuck
	@GetMapping("/update.json")
	@ResponseBody
	public String updateUser(User user) {
		return "success";
	}
	
	/// http://localhost/javabean/update2.json?id=1&name=fuck
	@GetMapping("/update2.json")
	@ResponseBody
	public String getUser2(int id, String name) {
		return "success";
	}
	
	/// 接收表单
	/// http://localhost/addOrder.html
	@PostMapping("/saveOrder.json")
	@ResponseBody
	public String saveOrder(OrderPostForm form) {
		return "success";
	}
	
	/**
	 curl -XPOST 'http://localhost/javabean/savejsonorder.json' -H 'Content-Type: application/json' -d'
	 {
	 	"name":"hello",
	 	"id":1
	 }
	 '
	 
	 */
	/// RequestBody 表示接收json数据
	@PostMapping("/savejsonorder.json")
	@ResponseBody
	public String saveOrderByJson(@RequestBody User user) {
		return "success";
	}
}
