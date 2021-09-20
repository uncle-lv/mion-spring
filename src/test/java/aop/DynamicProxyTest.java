package aop;

import aop.aspectj.AspectJExpressionPointcut;
import aop.aspectj.AspectJExpressionPointcutAdvisor;
import aop.framework.CglibAopProxy;
import aop.framework.JdkDynamicAopProxy;
import aop.framework.ProxyFactory;
import aop.framework.adapter.MethodAfterAdviceInterceptor;
import aop.framework.adapter.MethodAfterReturningAdviceInterceptor;
import aop.framework.adapter.MethodBeforeAdviceInterceptor;
import aop.framework.adapter.MethodThrowingAdviceInterceptor;
import common.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.WorldService;
import service.WorldServiceImpl;

public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @BeforeEach
    public void setup() {
        WorldService worldService = new WorldServiceImpl();
        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor worldServiceInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(worldServiceInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception {
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodBeforeAdviceInterceptor);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterAdvice() throws Exception {
        WorldServiceAfterAdvice afterAdvice = new WorldServiceAfterAdvice();
        MethodAfterAdviceInterceptor methodAfterAdviceInterceptor = new MethodAfterAdviceInterceptor(afterAdvice);
        advisedSupport.setMethodInterceptor(methodAfterAdviceInterceptor);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterReturningAdvice() throws Exception {
        WorldServiceAfterReturningAdvice afterReturningAdvice = new WorldServiceAfterReturningAdvice();
        MethodAfterReturningAdviceInterceptor methodAfterReturningAdviceInterceptor = new MethodAfterReturningAdviceInterceptor(afterReturningAdvice);
        advisedSupport.setMethodInterceptor(methodAfterReturningAdviceInterceptor);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testThrowingAdvice() throws Exception {
        WorldServiceThrowingAdvice throwingAdvice = new WorldServiceThrowingAdvice();
        MethodThrowingAdviceInterceptor methodThrowingAdviceInterceptor = new MethodThrowingAdviceInterceptor(throwingAdvice);
        advisedSupport.setMethodInterceptor(methodThrowingAdviceInterceptor);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception {
        String expression = "execution(* service.WorldService.explode(..))";
        WorldService worldService = new WorldServiceImpl();
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodBeforeAdviceInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();

        }
    }
}
