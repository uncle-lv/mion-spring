package org.mion.context.event;

import org.mion.context.ApplicationEvent;
import org.mion.context.ApplicationListener;

public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);
    void removeApplicationListener(ApplicationListener<?> listener);
    void multicastEvent(ApplicationEvent event);
}
