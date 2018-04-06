package com.d7kj.controller.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer>{

	WorkOverTime work;
	int max;
	
	/// 获取注解的定义
	public void initialize(WorkOverTime work) {
		this.work = work;
		max = work.max();
	}
	
	/// 校验逻辑
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {		
		if(value == null)return true;
		return value < max;
	}

}
