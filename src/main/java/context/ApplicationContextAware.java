package context;

import beans.exception.BeansException;
import beans.factory.Aware;
import context.ApplicationContext;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
