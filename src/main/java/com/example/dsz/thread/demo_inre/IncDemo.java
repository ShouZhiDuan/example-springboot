package com.example.dsz.thread.demo_inre;

import lombok.Data;
import org.junit.Test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/22 13:27
 * @Description:
 */
@Data
public class IncDemo {

    private static Integer a = 0;

    public static void incr() {
        synchronized (IncDemo.class) {
            a++;
            System.out.println("最终值======>" + a);
        }
    }

    public IncDemo(int a) {

    }

    //针对于具体实例上的锁
    public synchronized void test() {
        System.out.println();
    }

    //全局锁
    public static synchronized void test2() {
        System.out.println();
    }

    //实例锁
    public void test3() {
        synchronized (this) {
            System.out.println();
        }
    }

    @Test
    public void test4() throws NoSuchMethodException {
        IncDemo[] as = new IncDemo[9];
        System.out.println(as.getClass().getName());
        System.out.println(IncDemo.class.getConstructors().length);


    }


}
