package com.modern.training.platform.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectConfig {

	Logger log = LoggerFactory.getLogger(this.getClass());

	// add Before advice
	@Before("execution(* com.modern.training.platform.controller.*.*(..))")
	public void before(JoinPoint theJoinPoint) {
		// display the method and arguments we are calling
		String methodName = theJoinPoint.getSignature().toShortString();
		Object[] args = theJoinPoint.getArgs();
		log.info("MTP.trace." + methodName+":"+Arrays.toString(args));
	}
}
