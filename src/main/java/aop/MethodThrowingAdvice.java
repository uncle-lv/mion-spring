package aop;

import java.lang.reflect.Method;

public interface MethodThrowingAdvice extends ThrowingAdvice {
    void throwing(Method method, Object[] args, Object target) throws Throwable;
}
