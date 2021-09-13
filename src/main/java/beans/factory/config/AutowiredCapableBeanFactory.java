package beans.factory.config;

import beans.exception.BeansException;
import beans.factory.BeanFactory;

public interface AutowiredCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
