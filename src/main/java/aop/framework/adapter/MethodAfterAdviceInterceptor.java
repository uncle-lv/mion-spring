package aop.framework.adapter;

import aop.MethodAfterAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodAfterAdviceInterceptor implements MethodInterceptor {

    private final MethodAfterAdvice afterAdvice;

    public MethodAfterAdviceInterceptor(MethodAfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result;
        try {
            result = methodInvocation.proceed();
        } finally {
            this.afterAdvice.after(
                    methodInvocation.getMethod(),
                    methodInvocation.getArguments(),
                    methodInvocation.getThis()
            );
        }
        return result;
    }
}
