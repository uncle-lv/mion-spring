package beans.factory;

import beans.exception.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException;
    String[] getBeanDefinitionNames();
}
