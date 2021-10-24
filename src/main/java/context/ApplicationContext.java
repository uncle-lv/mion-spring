package context;

import beans.factory.HierarchicalBeanFactory;
import beans.factory.ListableBeanFactory;
import io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
