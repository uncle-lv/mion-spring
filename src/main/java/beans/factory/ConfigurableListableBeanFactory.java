package beans.factory;

import beans.exception.BeansException;
import beans.factory.config.AutowiredCapableBeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowiredCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
