package ioc;

import beans.Phone;
import context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrototypeBeanTest {

    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Phone phone1 = applicationContext.getBean("phone", Phone.class);
        Phone phone2 = applicationContext.getBean("phone", Phone.class);
        Assertions.assertTrue(phone1 != phone2);
    }
}
