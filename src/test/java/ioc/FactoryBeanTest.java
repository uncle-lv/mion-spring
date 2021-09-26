package ioc;

import beans.Phone;
import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
        Phone phone = applicationContext.getBean("phone", Phone.class);
        Assertions.assertEquals("IPhone", phone.getBrand());
    }
}
