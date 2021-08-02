package com.day.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {
    private Logger log = Logger.getLogger(MyAdvice.class);

    @Before("execution(* log*(..)) ||  execution(* findById(*))" ) //login()메서드 호출 직전에 아래의 beforeLog()메서드가 호출됨.
    public void beforeLog() {
        log.error("Before");
    }

    @Around("execution(* log*(..))")
    public void arroundLog(ProceedingJoinPoint pjp) throws Throwable {
        String pMethodName = pjp.getKind(); // 포인트컷메서드 호출
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            log.error("포인트컷 메서드 매개변수 : " + arg);
        }
        log.error("Arround 포인트컷 메서드 (" + pMethodName + ") 호출전");

        pjp.proceed(); // 포인트컷 메서드 호출

        log.error("Arround 포인트컷 메서드 (" + pMethodName + ") 호출후");
    }
}
