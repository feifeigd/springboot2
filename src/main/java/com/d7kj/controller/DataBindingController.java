package com.d7kj.controller;

import java.util.Date;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.entity.User;

@Controller
@RequestMapping("/databind")
public class DataBindingController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// 如何绑定到Date参数
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	/// http://localhost/databind/date?d=2018-4-6
	@ResponseBody
	@RequestMapping("/date")
	public User printDate(Date d) {
		System.out.println(d);
		return new User();
	}
}
