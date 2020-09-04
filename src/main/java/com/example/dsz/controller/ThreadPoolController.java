package com.example.dsz.controller;

import com.example.dsz.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/12 15:12
 * @Description: 线程池
 * https://blog.csdn.net/boling_cavalry/article/details/79120268
 */
@RestController
@RequestMapping("/test")
public class ThreadPoolController {


    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolController.class);


    @Autowired
    private TestService testService;


    @GetMapping("/do")
    public Object testThread(String msg){
        String result = testService.testDo(msg);
        return result;
    }





}
