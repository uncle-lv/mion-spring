package org.mion.context.event;

import org.mion.context.ApplicationContext;
import org.mion.context.ApplicationEvent;

public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
