package ioc;

import beans.Person;
import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");
        Person person = applicationContext.getBean(Person.class);
        Assertions.assertNotNull(person.getPhone());
    }
}
