package common;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class WorldServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info("Do something before explode...");
        Object result = methodInvocation.proceed();
        log.info("Do something after explode...");
        return result;
    }
}
