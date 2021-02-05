package com.example.dsz.event_listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/5 10:23
 * @Description:
 */
@Component
public class Demo {
    private int age = 10;
    private String name = "shouzhi.duan";
    public Demo() {
    }
}
