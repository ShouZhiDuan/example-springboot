package com.example.dsz.jdk_cglib_proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/29 15:45
 * @Description:
 */
public class CGLIBHandler implements MethodInterceptor {

    /**
     * 生成代理对象
     */
    public Object getNewInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * @param o           被代理的实例
     * @param method      被代理的方法
     * @param objects     被代理方法参数
     * @param methodProxy 代理后的方法
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======开始代理======");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("======结束代理======");
        return invoke;
    }


    static class TestCglib {
        public void test() {
            System.out.println("com.example.dsz.jdk_cglib_proxy.cglib.CGLIBHandler.TestCglib");
        }
    }

    public static void main(String[] args) {
        CGLIBHandler cglibHandler = new CGLIBHandler();
        TestCglib newInstance = (TestCglib) cglibHandler.getNewInstance(TestCglib.class);
        newInstance.test();
    }
}
