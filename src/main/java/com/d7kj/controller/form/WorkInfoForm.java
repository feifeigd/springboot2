package com.d7kj.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.d7kj.controller.validate.WorkOverTime;

import lombok.Data;

@Data
public class WorkInfoForm {

	// 定义一个类,更新时校验组
	public interface Update{}
	
	// 定义一个类,添加时校验组
	public interface Add{}
	
	// 当校验上下文为Update.class的时候,id不能为空
	@NotNull(groups= {Update.class})
	// 当校验上下文为Add.class的时候,id需要为空
	@Null(groups= {Add.class})
	int id;
	
	// 长度检查
	@Size(min=3,max=30)
	String name;
	
	@Email
	String email;
	
	// 自定义验证
	// 加班时间
	@WorkOverTime(max=5)
	Integer workTime;
}
