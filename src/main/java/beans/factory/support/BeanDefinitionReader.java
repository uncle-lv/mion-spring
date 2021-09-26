package beans.factory.support;

import beans.exception.BeansException;
import org.mion.core.io.Resource;
import org.mion.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String[] locations) throws BeansException;
}
