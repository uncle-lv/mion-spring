package common.event;

import org.mion.context.event.ApplicationContextEvent;

public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(Object source) {
        super(source);
    }
}
