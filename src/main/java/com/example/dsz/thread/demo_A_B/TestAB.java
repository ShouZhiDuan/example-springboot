package com.example.dsz.thread.demo_A_B;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/18 23:12
 * @Description:
 */
public class TestAB {
    public static void main(String[] args){
        Object lock = new Object();
        AtomicReference<Boolean> flage = new AtomicReference<>(true);
        Thread threadA = new Thread(() -> {
            while (true){
                if(flage.get()){
                    synchronized (lock) {
                        try {
                            System.out.println("A");
                            flage.set(false);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread threadB = new Thread(() -> {
            while (true){
                if(!flage.get()){
                    synchronized (lock) {
                        System.out.println("B");
                        lock.notify();
                        flage.set(true);
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }










}
