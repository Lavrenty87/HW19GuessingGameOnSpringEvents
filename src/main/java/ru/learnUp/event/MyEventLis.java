package ru.learnUp.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
@Slf4j
public class MyEventLis implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(event.getData());
    }
}
