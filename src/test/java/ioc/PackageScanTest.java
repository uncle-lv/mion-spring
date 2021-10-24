package ioc;

import beans.Phone;
import context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackageScanTest {

    @Test
    public void testScanPackage() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");
        Phone phone = applicationContext.getBean("phone", Phone.class);
        Assertions.assertNotNull(phone);
    }
}
