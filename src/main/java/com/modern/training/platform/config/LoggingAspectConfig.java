package com.modern.training.platform.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspectConfig {

	// add Before advice
	@Before("execution(* com.modern.training.platform.controller.*.*(..))")
	public void before(JoinPoint theJoinPoint) {
		// display the method and arguments we are calling
		String methodName = theJoinPoint.getSignature().toShortString();
		Object[] args = theJoinPoint.getArgs();
		log.info("MTP.trace." + methodName + ":" + Arrays.toString(args));
	}
}
