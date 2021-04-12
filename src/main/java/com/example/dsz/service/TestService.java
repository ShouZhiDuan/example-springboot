package com.example.dsz.service;

import com.example.dsz.model.DszTest;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/12 15:13
 * @Description:
 */
public interface TestService {

    String testDo(String msg);

    DszTest queryTest();

}
