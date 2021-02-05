package com.example.dsz.event_listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 10:15
 * @Description: ContextRefreshedEvent
 */
public class EventTest implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent demo) {
        System.out.println();
    }
}
