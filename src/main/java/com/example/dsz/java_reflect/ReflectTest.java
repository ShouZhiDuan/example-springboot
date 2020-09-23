package com.example.dsz.java_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/23 10:08
 * @Description:
 */
public class ReflectTest {

    @Test
    public void test1(){
        Class<Demo> demoClass = Demo.class;
        Method[] declaredMethods = demoClass.getDeclaredMethods();
        Constructor<?>[] constructors = demoClass.getConstructors();
        System.out.println(declaredMethods);
        System.out.println(constructors);
    }



}
