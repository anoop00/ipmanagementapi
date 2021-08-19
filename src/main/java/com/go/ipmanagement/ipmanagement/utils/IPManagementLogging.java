package com.go.ipmanagement.ipmanagement.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class IPManagementLogging {

	Logger log = LoggerFactory.getLogger(IPManagementLogging.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	@Pointcut(value = "execution(* com.go.ipmanagement.ipmanagement.*.*.*(..))")
	public void loggerPointCut() {
		
	}
	
	@Around("loggerPointCut()")
	public Object ipManagementLogger(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();

		Object[] args = point.getArgs();
		log.info("Method call " + className + " : " + methodName + " -->" + " arguements : "
				+ objectMapper.writeValueAsString(args));
		Object response = point.proceed();
		log.info("Method call " + className + " : " + methodName + " -->" + " arguements : "
				+ objectMapper.writeValueAsString(response));
		return response;
	}
}
