package service;

import beans.exception.BeansException;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import org.mion.context.ApplicationContext;
import org.mion.context.ApplicationContextAware;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public String sayHello() {
        log.info("Hello");
        return "Hello";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
