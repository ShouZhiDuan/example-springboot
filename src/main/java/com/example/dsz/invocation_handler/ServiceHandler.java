package com.example.dsz.invocation_handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/26 9:34
 * @Description:
 */
public class ServiceHandler implements InvocationHandler {

    private Object target;

    public ServiceHandler() {

    }

    public ServiceHandler(Object target) {
        this.target = target;
    }

    public TestHandlerService proxy(){
      return (TestHandlerService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        Class<?> returnType = method.getReturnType();
        if(returnType==String.class){
            System.out.println("返回字符串类型");
        }
        Object invoke = method.invoke(target,args);
        System.out.println("结束代理");
        return invoke;
    }


    public static void main(String[] args) {
        TestHandlerService proxy = new ServiceHandler(new TestHandlerServiceImpl2()).proxy();
        proxy.say();
    }
}
