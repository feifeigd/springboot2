package com.d7kj.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import com.d7kj.annotation.Function;

@Aspect
@Configuration
public class RoleAccessConfig {

	@Around("within(@org.springframework.stereotype.Controller *) && @annotation(function)")
	public Object functionAccessCheck(final ProceedingJoinPoint pjp, Function function) throws Throwable {
		if(function!=null) {
			String functionName = function.value();
			if(!canAccess(functionName)) {
				MethodSignature ms = (MethodSignature) pjp.getSignature();
				throw new RuntimeException("Can not Access "+ms.getMethod());
			}
		}
		Object o = pjp.proceed();
		return o;
	}

	private boolean canAccess(String functionName) {
		// TODO Auto-generated method stub
		if(0 == functionName.length())
			return true;
		// 取出当前用户对应的所有角色，从数据库查询角色是否有访问functionName的权限。
		return false;
	}
}
