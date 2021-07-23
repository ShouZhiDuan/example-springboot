package com.example.dsz.thread.demo_inre;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/22 13:29
 * @Description:
 */
public class IncrTesy {
    public static void main(String[] args) {
        for (int i = 0; i <= 9999; i++) {
            new Thread(() -> {
                IncDemo.incr();
            }).start();
        }
    }
}
