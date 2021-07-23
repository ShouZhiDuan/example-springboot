package com.example.dsz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/7/24 11:38
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class DockerTestController {

    @GetMapping("/docker")
    private Object helloWord() {
        return "Hello Docker My Name is ShouZhi@Duan ! ! ! ! ! !";
    }


}
