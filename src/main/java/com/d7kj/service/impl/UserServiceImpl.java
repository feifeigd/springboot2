package com.d7kj.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.d7kj.service.CreditSystemService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d7kj.dao.UserDao;
import com.d7kj.entity.User;
import com.d7kj.service.UserService;

/// 自动生成bean
/// Service是个bean
@Service
/// 添加事务
@Transactional
public class UserServiceImpl implements UserService {

	//@Autowired
	//SQLManager sqlManager;

	@Autowired
	CreditSystemService creditSystemService;

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> allUser() {
		return sampleUser(5);
	}

	@Override
	public User getUserById(int id) {
		//User user = userDao.unique(id);	// 不存在,抛异常
		User user = userDao.single(id);	// 不存在,返回null
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

	@Override
	public List<User> select(String name) {
		User paras = new User();
		paras.setName(name);
		return userDao.selectSample(paras);
	}

	@Override
	public int getCredit(int userId) {
		return creditSystemService.getUserCredit(userId);
	}

	@Override
	public boolean updateUser(User user) {
		int ret = userDao.updateById(user);
		return 1 == ret;
	}

}
