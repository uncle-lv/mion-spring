package ioc;

import beans.factory.config.BeanDefinition;
import beans.factory.support.CglibSubclassingInstantiationStrategy;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.UserService;

public class InstantiationStrategyTest {

    @Test
    public void testSimpleInstantiationStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        Assertions.assertEquals("Tom", userService.getUserName());
    }

    @Test
    public void testCglibSubclassingInstantiationStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        Assertions.assertEquals("Tom", userService.getUserName());
    }
}
