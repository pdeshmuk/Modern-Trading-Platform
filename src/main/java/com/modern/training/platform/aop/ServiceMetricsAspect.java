package com.modern.training.platform.aop;

import java.time.Duration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class ServiceMetricsAspect {
	
	private final MeterRegistry meterRegistry;
	
    @Around("execution(public * com.modern.training.platform.service..*(..))")
    public Object doServiceTimers(ProceedingJoinPoint pjp) throws Throwable {

    	StopWatch sw = new StopWatch();
    	sw.start();
    	Object result = pjp.proceed();
    	sw.stop();

    	String timerName = pjp.getSignature().getDeclaringType().getName() + '.' + pjp.getSignature().getName() + ".timer";
    	timerName = timerName.replace("com.modern.training.platform", "c.m.t.p");
    	
    	Timer timer = meterRegistry.timer(timerName);
    	timer.record(Duration.ofMillis(sw.getTotalTimeMillis()));
        
        return result;
    }
    
    
}


