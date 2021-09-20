package aop.framework.adapter;

import aop.MethodThrowingAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodThrowingAdviceInterceptor implements MethodInterceptor {

    private final MethodThrowingAdvice throwingAdvice;

    public MethodThrowingAdviceInterceptor(MethodThrowingAdvice throwingAdvice) {
        this.throwingAdvice = throwingAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (Throwable e) {
            this.throwingAdvice.throwing(
                    methodInvocation.getMethod(),
                    methodInvocation.getArguments(),
                    methodInvocation.getThis()
            );
            throw e;
        }
    }
}
