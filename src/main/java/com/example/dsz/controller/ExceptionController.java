package com.example.dsz.controller;

import com.example.dsz.enums.GlobalExceptionCodeEnum;
import com.example.dsz.handler.GlobalException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/1 14:38
 * @Description: 异常测试
 */
@RestController
@RequestMapping("/exe")
public class ExceptionController {

    @GetMapping("/hello")
    private Object hello() {
        return "你好，段守志！！！！！！";
    }

    @GetMapping("/test")
    private void test() {
        test2();
    }


    private void test2() {
        try {
            test3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test3() {
        throw new GlobalException(GlobalExceptionCodeEnum.TOKEN_EXCEPTION_CODE);
    }

}
