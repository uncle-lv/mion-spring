package beans.factory;

import beans.exception.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
