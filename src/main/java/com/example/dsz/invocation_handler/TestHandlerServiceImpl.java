package com.example.dsz.invocation_handler;

import com.github.pagehelper.PageHelper;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 9:37
 * @Description:
 */
public class TestHandlerServiceImpl implements TestHandlerService {

    @Override
    public String say() {
        PageHelper.startPage(1,10);
        System.out.println("======TestHandlerServiceImpl======");
        return "代理返回值";
    }
}
