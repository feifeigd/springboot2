package com.d7kj.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserReditRestController {
	
	/// 反回json
	@RequestMapping(value="/usercredit/{id}")
	public Integer getCreditLevel(String id) {
		return 38;
	}
}
