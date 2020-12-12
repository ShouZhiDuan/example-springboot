package com.example.dsz.java_agent;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/11 17:24
 * @Description:
 */
public class TimeTest {

    public static void sayHello() {
        try {
            Thread.sleep(2000);
            System.out.println("hello world!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sayHello2(String hello) {
        try {
            Thread.sleep(1000);
            System.out.println(hello);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
