package common.event;

import org.mion.context.ApplicationListener;
import org.mion.context.event.ContextClosedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info(this.getClass().getName());
    }
}
