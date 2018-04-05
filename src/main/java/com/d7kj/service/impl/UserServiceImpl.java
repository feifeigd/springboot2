package com.d7kj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.d7kj.entity.User;
import com.d7kj.service.UserService;

/// 自动生成bean
@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> allUser() {
		return sampleUser(5);
	}

	@Override
	public User getUserById(int id) {
		User user = sampleUser(1).get(0);
		user.setId(id);
		return user;
	}
	
	private List<User> sampleUser(int num) {
		List<User> list = new ArrayList<User>(num);
		for(int i = 0; i < num; ++i) {
			User user = new User();
			user.setId(i);
			user.setName("name" + i);
			list.add(user);
		}
		return list;
	}

	@Override
	public void updateUser(int id, Integer type) {
		// TODO Auto-generated method stub

	}

}
