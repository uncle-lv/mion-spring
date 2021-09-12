package beans.factory.support;

import beans.exception.BeansException;
import beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return  constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate \"" + beanClass.getName() + "\"", e);
        }
    }
}
