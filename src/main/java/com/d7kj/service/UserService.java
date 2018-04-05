package com.d7kj.service;

import java.util.List;

import com.d7kj.entity.User;

public interface UserService {
	public List<User>	allUser();
	public User getUserById(int id);
	public void updateUser(int id, Integer type);
}
