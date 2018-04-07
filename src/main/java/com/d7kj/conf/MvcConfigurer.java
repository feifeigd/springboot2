package com.d7kj.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.d7kj.entity.User;

/// 用来全局定制化SpringBoot的MVC特性
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
	
	/// 拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		// 增加一个拦截器,检查会话,URL以admin开头的都使用此拦截器
		SessionHandlerInterceptor interceptor = new SessionHandlerInterceptor();
		InterceptorRegistration registration = registry.addInterceptor(interceptor);
		registration.addPathPatterns("/user/**");
	}
	
	class SessionHandlerInterceptor implements HandlerInterceptor{
		
		/// 检查用户是否已经登录，如果未登录，重定向到登录页面
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			User user = (User) request.getSession().getAttribute("user");
			if(user == null) {
				response.sendRedirect("/login.html");
				return false;
			}
			return true;
		}
	}
}
