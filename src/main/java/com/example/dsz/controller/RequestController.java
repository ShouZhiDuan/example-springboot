package com.example.dsz.controller;

import com.alibaba.fastjson.JSON;
import com.example.dsz.dto.TestQuery;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/14 17:58
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class RequestController {


    @PostMapping("/post")
    public Object testPost(@RequestParam String name) {
        return name;
    }


    @PostMapping("/post2")
    public Object testPost2(TestQuery query) {
        return query;
    }


    @PostMapping("/post3")
    public Object testPost3(@RequestBody TestParam param) {
        return JSON.toJSONString(param);
    }


    enum TestStatus {
        one(1),
        two(2);

        private int code;

        TestStatus(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    @Data
    static class TestParam {
        private int Id;
        private TestStatus status;
    }


}
