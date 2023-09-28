package com.d7kj.dao;

import java.util.List;

import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.BaseMapper;

import com.d7kj.entity.User;

// /resources/sql/www.user.md 文件路径
@SqlResource("www.user")
// 任何继承BaseMapper的类，将自动具备实体内置的CRUD功能
public interface UserDao extends BaseMapper<User> {
	// 方法名跟md文件中的===前面那行名字一样
	// 不用写函数体
	public List<User> selectSample(User query);
}
