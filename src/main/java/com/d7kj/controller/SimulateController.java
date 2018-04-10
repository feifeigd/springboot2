package com.d7kj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimulateController {
	
	@Autowired
	private WebSimulate webSimulate;

	/// 未实现的api
	// http://localhost/api/simulatejson.html
	@RequestMapping("/api/**")
	public void simulateJson(HttpServletRequest request, HttpServletResponse response) {
		webSimulate.execute(request, response);
	}
	
	/// 未实现的页面请求
	/// http://localhost/simulateview.html
	@RequestMapping("/**/*.html")
	public void simulateView(HttpServletRequest request, HttpServletResponse response) {
		webSimulate.execute(request, response);
	}
}
