package com.d7kj.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ErrorController extends AbstractErrorController {

	static final String ERROR_PATH = "/error";
	private Log log = LogFactory.getLog(ErrorController.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	public ErrorController() {
		super(new DefaultErrorAttributes());
	}
	
	@RequestMapping(ERROR_PATH)
	public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
		Throwable cause = getCause(request);
		// HTTP状态码
		int status = (int)model.get("status");
		response.setStatus(status);
		// 详细错误信息
		String message = (String)model.get("message");
		String errorMessage = getErrorMessage(cause);
		String requestPath = (String)model.get("path");
		// 后台控制台打印日志信息方便查错
		log.info(status + "," + message, cause);
		log.info("requestpPath" + ":" + requestPath);
		if(!isJsonRequest(request)) {
			ModelAndView view = new ModelAndView("/error.html");
			view.addAllObjects(model)
				.addObject("status", status)
				.addObject("errorMessage", errorMessage)
				.addObject("cause", cause);
			
			return view;
		}
		// 如果是json请求,则返回一个json格式的错误
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("success", false);
		error.put("errorMessage", errorMessage);
		error.put("message", message);
		writeJson(response, error);
		return null;
	}

	private void writeJson(HttpServletResponse response, Map<String, Object> error) {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(objectMapper.writeValueAsString(error));
		}catch(IOException e) {
			// 忽略异常
		}		
	}

	/// 是否json请求
	private boolean isJsonRequest(HttpServletRequest request) {
		//String requestUri = request.getRequestURI();
		String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
		if(requestUri.endsWith(".json"))
			return true;
		return request.getHeader("accept").contains("application/json")
			|| (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").contains("XMLHttpRequest"));
	}

	/// 友好提示
	private String getErrorMessage(Throwable cause) {
		// 不给前端显示详细错误
		return "服务器错误,请联系管理员.";
	}

	private Throwable getCause(HttpServletRequest request) {		
		Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
		if(error != null) {
			// MVC有可能会封装异常成ServletException,需要调用其getCause获取真正的异常
			while(error instanceof ServletException && error.getCause() != null)
				error = ((ServletException)error).getCause();
		}
		return error;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}