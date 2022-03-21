package ru.learnUp.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private final String date;

    public MyEvent(String date) {
        super(date);
        this.date = date;
    }
    public String getData() {
        return date;
    }

}
