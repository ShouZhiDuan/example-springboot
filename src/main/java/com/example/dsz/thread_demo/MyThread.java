package com.example.dsz.thread_demo;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 14:34
 * @Description:
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("执行run方法");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }


}
