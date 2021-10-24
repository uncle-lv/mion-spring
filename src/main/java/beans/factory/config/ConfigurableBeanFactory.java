package beans.factory.config;

import beans.factory.HierarchicalBeanFactory;
import util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
    void destroySingletons();
    void addEmbeddedValueResolver(StringValueResolver valueResolver);
    String resolverEmbeddedValue(String value);
}
