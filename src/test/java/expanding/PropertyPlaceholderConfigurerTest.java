package expanding;

import beans.Phone;
import org.mion.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropertyPlaceholderConfigurerTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");
        Phone phone = applicationContext.getBean("phone", Phone.class);
        Assertions.assertEquals("IPhone", phone.getBrand());
    }
}
