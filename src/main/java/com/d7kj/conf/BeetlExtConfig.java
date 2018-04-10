package com.d7kj.conf;

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
		groupTemplate.registerFunction("hi", simple);
	}
}
