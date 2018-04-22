package com.d7kj.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.d7kj.entity.User;

// /template/sql/www.user.md 文件路径
@SqlResource("www.user")
public interface UserDao extends BaseMapper<User> {
	// 方法名跟md文件中的===前面那行名字一样
	public List<User> selectSample(User query);
}
