package com.d7kj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d7kj.controller.form.WorkInfoForm;
import com.d7kj.entity.User;

@Controller
@RequestMapping("/databind")
public class DataBindingController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// 如何绑定到Date参数
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
		
		// 绑定WorkInfoForm,验证
		binder.addValidators(new Validator() {

			// 触发该验证器的条件
			@Override
			public boolean supports(Class<?> clazz) {
				return clazz == WorkInfoForm.class;
			}

			@Override
			public void validate(Object target, Errors errors) {
				WorkInfoForm form = (WorkInfoForm)target;
			}			
		});
	}
	
	/// http://localhost/databind/date?d=2018-4-6
	@ResponseBody
	@RequestMapping("/date")
	public User printDate(Date d) {
		System.out.println(d);
		return new User();
	}
	
	/// http://localhost/databind/addworkinfo.html?name=monkey&id=1
	@ResponseBody
	@RequestMapping("/addworkinfo.html")
	public void addWorkInfo(@Validated({WorkInfoForm.Add.class}) WorkInfoForm workInfo, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			FieldError error = (FieldError)list.get(0);
			System.out.println(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
		}
	}
}
