package beans.factory;

import beans.exception.BeansException;

public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
