package com.d7kj.conf;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.d7kj.util.SimpleFunction;

@Configuration
public class BeetlExtConfig {

	@Autowired
	private GroupTemplate groupTemplate;
	
	/// 自己定义的函数
	@Autowired
	private SimpleFunction simple;

	// 启动阶段调用此方法,完成groupTemplate的扩展
	@PostConstruct
	public void config() {
		// 	注册全局函数
		groupTemplate.registerFunction("hi", simple);
		// 注册共享变量
		// 使用 <script src="/js/xx.js?version=${jsVersion}"></script>
		Map<String, Object> sharedVars = groupTemplate.getSharedVars();
		if(sharedVars == null) {
			sharedVars = new HashMap<String, Object>();
			groupTemplate.setSharedVars(sharedVars);
		}
		sharedVars.put("jsVersion", System.currentTimeMillis());
	}
}
