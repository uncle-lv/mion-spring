package org.mion.context;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
