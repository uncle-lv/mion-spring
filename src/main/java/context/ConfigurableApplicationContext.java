package context;

import beans.exception.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;
    void close();
    void registerShutdownHook();
}
