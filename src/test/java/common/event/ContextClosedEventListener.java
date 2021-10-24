package common.event;

import context.ApplicationListener;
import context.event.ContextClosedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info(this.getClass().getName());
    }
}
