package com.d7kj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling	// 发现注解@Scheduled的任务并后台执行
public class Application {

	/// 抄袭入口点
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
