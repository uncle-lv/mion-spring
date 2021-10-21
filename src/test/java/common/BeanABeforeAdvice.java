package common;

import aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeanABeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }
}
