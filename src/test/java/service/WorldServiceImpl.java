package service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorldServiceImpl implements WorldService {

    @Override
    public void explode() {
        log.info("explode...");
    }
}
