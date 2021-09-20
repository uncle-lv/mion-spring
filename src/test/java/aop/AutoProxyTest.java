package aop;

import beans.factory.config.BeanPostProcessor;
import context.support.ClassPathXmlApplicationContext;
import aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.junit.jupiter.api.Test;
import service.WorldService;

public class AutoProxyTest {

    @Test
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }
}
