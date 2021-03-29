package com.example.dsz.thread_local;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/29 13:51
 * @Description:
 * 使用ThreadLocal的最佳实践
 * 我们发现无论是set,get还是remove方法，过程中key为null的Entry都会被擦除，那么Entry内的value也就没有强引用链，GC时就会被回收。那么怎么会存在内存泄露呢？但是以上的思路是假设你调用get或者set方法了，很多时候我们都没有调用过，所以最佳实践就是*
 * 1 .使用者需要手动调用remove函数，删除不再使用的ThreadLocal.
 * 2 .还有尽量将ThreadLocal设置成private static的，这样ThreadLocal会尽量和线程本身一起消亡。
 */
public class TreadLocalTest {


    private static ThreadLocal<Integer> threadLocal = new ThreadLocal();


    @Test
    public void test(){
        Thread thread = new Thread(()->{
            threadLocal.set(100);
            System.out.println("100 " + Thread.currentThread().getId() + "value=" + threadLocal.get());
            threadLocal.remove();
            System.out.println("100 " + threadLocal);
        });
        Thread thread2 = new Thread(()->{
            threadLocal.set(200);
            System.out.println("200 " + Thread.currentThread().getId() + "value=" + threadLocal.get());
            threadLocal.remove();
            System.out.println("200" + threadLocal);
        });
        thread.start();
        thread2.start();
    }






























}
