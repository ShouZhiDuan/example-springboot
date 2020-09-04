package com.example.dsz.thread_demo;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 14:41
 * @Description:
 */
public class MyRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("执行MyRunable的run方法");
    }

    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        Thread thread = new Thread(myRunable);
        thread.start();
    }


}
