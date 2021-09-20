package common;

import aop.MethodThrowingAdvice;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class WorldServiceThrowingAdvice implements MethodThrowingAdvice {

    @Override
    public void throwing(Method method, Object[] args, Object target) throws Throwable {
        log.info("throwing...");
    }
}
