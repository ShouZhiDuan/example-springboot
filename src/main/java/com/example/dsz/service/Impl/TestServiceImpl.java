package com.example.dsz.service.Impl;

import com.example.dsz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/12 15:19
 * @Description:
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {



    @Override
    @Async("asyncServiceExecutor")
    public String testDo(String msg) {
        log.info("执行TestServiceImpl#testDo方法");
        return msg;
    }

}
