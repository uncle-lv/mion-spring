package aop.framework.adapter;

import aop.MethodAfterReturningAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodAfterReturningAdviceInterceptor implements MethodInterceptor {

    private final MethodAfterReturningAdvice afterReturningAdvice;

    public MethodAfterReturningAdviceInterceptor(MethodAfterReturningAdvice afterReturningAdvice) {
        this.afterReturningAdvice = afterReturningAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = methodInvocation.proceed();
        this.afterReturningAdvice.afterReturning(
                methodInvocation.getMethod(),
                methodInvocation.getArguments(),
                methodInvocation.getThis()
        );
        return result;
    }
}
