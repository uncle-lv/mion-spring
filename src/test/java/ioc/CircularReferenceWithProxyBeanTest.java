package ioc;

import beans.BeanA;
import beans.BeanB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mion.context.support.ClassPathXmlApplicationContext;

public class CircularReferenceWithProxyBeanTest {

    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-with-proxy-bean.xml");
        BeanA a = applicationContext.getBean("a", BeanA.class);
        BeanB b = applicationContext.getBean("b", BeanB.class);

        Assertions.assertTrue(b.getA() == a);
    }
}
