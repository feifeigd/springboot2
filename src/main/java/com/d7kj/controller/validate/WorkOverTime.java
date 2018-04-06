package com.d7kj.controller.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// 用什么类来验证注解
@Constraint(validatedBy= {WorkOverTimeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {
	String message()default "加班时间过长,不能超过{max}";
	int max() default 4;
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
