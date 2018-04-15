package com.d7kj.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.d7kj.entity.User;

// .md文件路径
@SqlResource("www.user")
public interface UserDao extends BaseMapper<User> {
	public List<User> selectSample(User query);
}
