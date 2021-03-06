package com.d7kj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {

	/// 抄袭入口点
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
