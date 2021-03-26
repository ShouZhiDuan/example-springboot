package com.example.dsz.invocation_handler;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 9:37
 * @Description:
 */
public class TestHandlerServiceImpl2 implements TestHandlerService {

    @Override
    public String say() {
        System.out.println("======TestHandlerServiceImpl2======");
        return "代理返回值2";
    }
}
