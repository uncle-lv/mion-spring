package common;

import aop.MethodAfterAdvice;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class WorldServiceAfterAdvice implements MethodAfterAdvice {

    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        log.info("AfterAdvice...");
    }
}
