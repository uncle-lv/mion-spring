package common.event;

import context.ApplicationListener;
import context.event.ContextRefreshedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(this.getClass().getName());
    }
}
