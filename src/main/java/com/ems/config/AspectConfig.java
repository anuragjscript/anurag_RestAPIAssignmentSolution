package com.ems.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class AspectConfig {
	
	// pointCut expression -> accessModifier returnType packageName.className.methodName(..)
	@Before(" execution( public * com.ems.service.*.*(..) ) ")
	public void logBeforeAllMethods(JoinPoint joinpoint) {
		log.info( joinpoint.getSignature().getName() + " started at " + new Date() );
	}
	
	// pointCut expression -> accessModifier returnType packageName.className.methodName(..)
	@After(" execution( public * com.ems.service.*.*(..) ) ")
	public void logAfterAllMethods(JoinPoint joinpoint) {
		log.info( joinpoint.getSignature().getName() + " ended at " + new Date() );
	}
	

}
