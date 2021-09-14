package common.event;

import context.event.ApplicationContextEvent;

public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(Object source) {
        super(source);
    }
}
