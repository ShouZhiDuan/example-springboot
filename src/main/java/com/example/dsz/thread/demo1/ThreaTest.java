package com.example.dsz.thread.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/18 16:20
 * @Description:
 */
public class ThreaTest {
    static {
        System.out.println("00000000000000000000000");
    }
    public static void main(String[] args) {
//        new Thread(() -> {
//            //run to do
//            while (true){
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("thread-test-1");
//            }
//        },"test-1").start();

//        new Thread(() -> {
//               while (true){
//                   synchronized (Object.class){
//                       System.out.println("111111111111111111111");
//                   }
//               }
//        },"lock-1").start();
//
//        new Thread(() -> {
//            while (true){
//                synchronized (Object.class){
//                    System.out.println("222222222222222222222");
//                }
//            }
//        },"lock-2").start();
//
//           ThreaTest threaTest = new ThreaTest();
//           ThreaTest threaTest1 = new ThreaTest();
//           ThreaTest threaTest2 = new ThreaTest();
        new Thread(
                () -> {
                    while (true){
                        System.out.println("继续跑，迎着眼泪和嘲笑。。。。。。");
                    }
                }).start();

    }
}
