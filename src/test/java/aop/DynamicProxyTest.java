package aop;

import aop.aspectj.AspectJExpressionPointcut;
import aop.framework.CglibAopProxy;
import aop.framework.JdkDynamicAopProxy;
import common.WorldServiceInterceptor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
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
}
