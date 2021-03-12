package com.example.dsz.controller;

import com.example.dsz.mapper.DszTestMapper;
import com.example.dsz.model.DszTest;
import com.example.dsz.mybatis.type_handler.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/12 17:51
 * @Description:
 */
@RestController
@RequestMapping("/type")
public class MyBatisTypeHandlerController {

    @Autowired
    private DszTestMapper dszTestMapper;

    @GetMapping("/handler")
    public void test(){
    }


}
