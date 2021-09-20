package common;

import aop.MethodAfterReturningAdvice;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class WorldServiceAfterReturningAdvice implements MethodAfterReturningAdvice {

    @Override
    public void afterReturning(Method method, Object[] args, Object target) throws Throwable {
        log.info("AfterReturning...");
    }
}
