package com.example.dsz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/11 11:47
 * @Description:
 */
@RestController
@RequestMapping("/dev")
public class ReBushuTestController {

    @GetMapping("/tools")
    public Object test() {
        return "777666";
    }

}
