package com.d7kj.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d7kj.controller.ApiUtil;
import com.d7kj.controller.MD5Util;
import com.d7kj.controller.NotRepeatSubmit;
import com.d7kj.controller.TokenInfo;
import com.d7kj.redis.RequestLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import com.d7kj.entity.User;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.concurrent.TimeUnit;

/// 用来全局定制化SpringBoot的MVC特性
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
	private static final String[] excludePathPatterns = {"/api/token/api_token"};

	@Autowired
	private TokenInterceptor tokenInterceptor;

	@Bean
	public RequestLimitInterceptor requestLimitInterceptor(){
		return new RequestLimitInterceptor();
	}

	/// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// super.addInterceptors(registry);
		// 增加一个拦截器,检查会话,URL以admin开头的都使用此拦截器
		registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");

		SessionHandlerInterceptor interceptor = new SessionHandlerInterceptor();
		InterceptorRegistration registration = registry.addInterceptor(interceptor);
		registration.addPathPatterns("/user/**");

		registry.addInterceptor(tokenInterceptor)
				.addPathPatterns("/api/**")
				.excludePathPatterns(excludePathPatterns);

		registry.addInterceptor(this.requestLimitInterceptor()).addPathPatterns("/test");
	}

	/// 跨域访问配置
	@Override
	public void addCorsMappings(CorsRegistry registry){

	}

	/// 格式化
	@Override
	public void addFormatters(FormatterRegistry registry){

	}

	/// URI 到视图的映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("index.html");
	}

	class SessionHandlerInterceptor implements HandlerInterceptor{
		
		/// 检查用户是否已经登录，如果未登录，重定向到登录页面
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			User user = (User) request.getSession().getAttribute("user");
			if(user == null) {
				/*response.sendRedirect("/login.html");
				return false;*/
			}
			return true;
		}
	}

	@Component
	public class TokenInterceptor extends HandlerInterceptorAdapter{
		// TOOD redis还没配置好 redisTemplate
		@Autowired
		private RedisTemplate redisTemplate;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			String token = request.getHeader("token");
			String timestamp = request.getHeader("timestamp");
			// 随机字符串
			String nonce = request.getHeader("nonce");
			String sign = request.getHeader("sign");
			Assert.isTrue(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(sign), "参数错误");

			// 获取超时时间
			NotRepeatSubmit notRepeatSubmit = ApiUtil.getNotRepeatSubmit(handler);
			long expireTime = notRepeatSubmit == null ? 5 * 60 * 1000 : notRepeatSubmit.value();

			// 2. 请求间隔
			long requestInterval = System.currentTimeMillis()- Long.parseLong(timestamp);
			Assert.isTrue(requestInterval < expireTime, "请求超时,请重新请求");

			// 3. 校验token是否存在
			/*ValueOperations<String, TokenInfo> tokenRedis = redisTemplate.opsForValue();
			TokenInfo tokenInfo = tokenRedis.get(token);
			Assert.notNull(tokenInfo, "token错误");

			// 4. 校验签名（将所有的参数加进来，防止别人篡改参数）所有参数看参数名升序排序拼接成url
			// 请求参数 + token + timestamp +nonce
			String signString = ApiUtil.concatSignString(request) + tokenInfo.getAppInfo().getKey() + token + timestamp + nonce;
			String signature = MD5Util.encode(signString);
			boolean flag = signature.equals(sign);
			Assert.isTrue(flag, "签名错误");

			// 5. 拒绝重复调用(第一次访问时存储，过期时间和请求超时保持一致)，只有标注不允许重复提交注解才会校验
			if (notRepeatSubmit != null){
				ValueOperations<String, Integer> signRedis = redisTemplate.opsForValue();
				boolean exists = redisTemplate.hasKey(sign);
				Assert.isTrue(!exists, "请勿重复提交");
				signRedis.set(sign, 0, expireTime, TimeUnit.MILLISECONDS);
			}*/
			return super.preHandle(request, response, handler);
		}
	}
}
