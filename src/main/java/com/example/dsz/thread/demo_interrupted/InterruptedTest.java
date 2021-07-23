package com.example.dsz.thread.demo_interrupted;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/18 17:21
 * @Description:
 */
public class InterruptedTest {

    @Test
    public void test1() {
        Thread thread = new Thread(
                () -> {
                    while (true) {
                        //System.out.println(Thread.currentThread().isInterrupted());
                        System.out.println("继续跑，迎着眼泪和嘲笑。。。。。。");
                    }
                }
                , "thread-name");
        thread.start();
    }

    @Test
    public void test2() {
        new Thread(
                () -> {
                    while (true) {
                        System.out.println("继续跑，迎着眼泪和嘲笑。。。。。。");
                    }
                }).start();
    }

    @Test
    public void test3() {
        while (true) {
            //System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("继续跑，迎着眼泪和嘲笑。。。。。。");
        }
    }

    /**
     * 当线程者处于执行的过程中接收到 interrupt操作会复位，并且抛出InterruptedException异常
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    while (true) {
                        if (!Thread.currentThread().isInterrupted()) {
                            System.out.println("继续跑，迎着眼泪和嘲笑。。。。。。");
                        } else {
                            // Thread.interrupted();//复位设置成false
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                System.out.println(Thread.currentThread().isInterrupted());
                            }
                        }
                    }
                }
                , "thread-name");
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        thread.interrupt();//终断设置成true
    }


}
