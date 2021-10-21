package ioc;

import beans.BeanA;
import beans.BeanB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mion.context.support.ClassPathXmlApplicationContext;

public class CircularReferenceWithoutProxyBeanTest {

    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-without-proxy-bean.xml");
        BeanA a = applicationContext.getBean("a", BeanA.class);
        BeanB b = applicationContext.getBean("b", BeanB.class);
        Assertions.assertTrue(a.getB() == b);
    }
}
