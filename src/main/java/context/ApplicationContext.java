package context;

import beans.factory.HierarchicalBeanFactory;
import beans.factory.ListableBeanFactory;
import core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
