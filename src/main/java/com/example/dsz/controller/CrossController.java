package com.example.dsz.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 21:44
 * @Description: 跨域
 */
@RestController
@RequestMapping("/cross")
public class CrossController {

    @CrossOrigin
    @GetMapping("/test")
    public void test() {
        System.out.println("666666");
    }


}
