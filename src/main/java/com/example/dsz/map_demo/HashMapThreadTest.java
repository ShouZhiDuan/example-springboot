package com.example.dsz.map_demo;

import java.util.HashMap;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/24 11:22
 * @Description:
 */
public class HashMapThreadTest {
    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);

    // 2*0.75=1 超过1扩容开始
    public static void main(String[] args) {
        map.put(5, "C");
        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }

            ;
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }

            ;
        }.start();
    }
}
