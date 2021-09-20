package aop;

import java.lang.reflect.Method;

public interface MethodAfterReturningAdvice extends AfterAdvice {
    void afterReturning(Method method, Object[] args, Object target) throws Throwable;
}
