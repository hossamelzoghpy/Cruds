package com.jpa.book.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(1)
@Component
public class LogInfoAspect {
	Logger log = LoggerFactory.getLogger(LogInfoAspect.class);
	@Pointcut(value="execution(* com.jpa.book.repo.*.*(..))")
	public void forRepoLog() {}
	
	@Pointcut(value="execution(* com.jpa.book.service.*.*(..))")
	public void forServiceLog() {}
	
	@Pointcut(value="execution(* com.jpa.book.controller.*.*(..))")
	public void forControllerLog() {}
	
	@Pointcut(value="forRepoLog() || forServiceLog() || forControllerLog()")
	public void forAllLog() {}
	
	@Before(value="forAllLog()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName=joinPoint.getSignature().getName();
		log.info("Method name ====> {}",methodName);
		Object[] args=joinPoint.getArgs();
		for(Object arg:args) {
			log.info("Arguments ===> {} ",arg);
		}
		
	}
}
