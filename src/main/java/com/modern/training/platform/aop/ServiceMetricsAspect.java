package com.modern.training.platform.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;


@Aspect
@Component
public class ServiceMetricsAspect {
	
	@Autowired 
	private MeterRegistry mr;
	
	
    @Around("execution(public * com.modern.training.platform.service..*(..))")
    public Object doServiceTimers(ProceedingJoinPoint pjp) throws Throwable {

    	long t0 = System.currentTimeMillis();
    	Object retVal = pjp.proceed();
    	long t1 = System.currentTimeMillis();

    	String timerName = pjp.getSignature().getDeclaringType().getName() + '.' + pjp.getSignature().getName() + ".timer";
    	Timer timer = mr.timer(timerName);
    	timer.record(t1-t0, TimeUnit.MILLISECONDS);
        
        return retVal;
    }
}


