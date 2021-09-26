package ioc;

import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.HelloService;

public class AwareInterfaceTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        Assertions.assertNotNull(helloService.getApplicationContext());
        Assertions.assertNotNull(helloService.getBeanFactory());
    }
}
