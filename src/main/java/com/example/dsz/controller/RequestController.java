package com.example.dsz.controller;

import com.example.dsz.dto.TestQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/14 17:58
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class RequestController {



    @PostMapping("/post")
    public Object testPost(@RequestParam String name){
        return name;
    }


    @PostMapping("/post2")
    public Object testPost2(TestQuery query){
        return query;
    }



}
