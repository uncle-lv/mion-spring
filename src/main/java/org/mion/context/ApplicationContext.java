package org.mion.context;

import beans.factory.HierarchicalBeanFactory;
import beans.factory.ListableBeanFactory;
import org.mion.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
