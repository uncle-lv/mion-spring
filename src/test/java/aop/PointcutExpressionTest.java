package aop;

import aop.aspectj.AspectJExpressionPointcut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.HelloService;

import java.lang.reflect.Method;

public class PointcutExpressionTest {

    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");

        Assertions.assertTrue(pointcut.matches(clazz));
        Assertions.assertTrue(pointcut.matches(method, clazz));
    }
}
