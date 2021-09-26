package ioc;

import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

public class InitAndDestoryMethodTest {

    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();
    }
}
