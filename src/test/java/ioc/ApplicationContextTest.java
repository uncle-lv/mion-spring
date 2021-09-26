package ioc;

import beans.Person;
import beans.Phone;
import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        Assertions.assertEquals("Tom", person.getName());

        Phone phone = applicationContext.getBean("phone", Phone.class);
        Assertions.assertEquals("IPhone", phone.getBrand());
    }
}
