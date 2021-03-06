package fr.fidtec.POC_AOP_With_Springframework;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class HijackAfterMethod implements AfterReturningAdvice {
	
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("HijackAfterMethod : After method hijacked! : " + returnValue);	
	}
	
}