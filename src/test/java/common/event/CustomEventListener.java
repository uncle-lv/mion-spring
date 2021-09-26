package common.event;

import org.mion.context.ApplicationListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info(this.getClass().getName());
    }
}
