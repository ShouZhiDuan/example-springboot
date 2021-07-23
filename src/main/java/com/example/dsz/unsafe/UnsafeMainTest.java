package com.example.dsz.unsafe;

import lombok.Data;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/29 16:13
 * @Description:
 */
public class UnsafeMainTest {

    public static void main(String[] args) {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe = (Unsafe) declaredField.get(null);
            //获取java内存指针大小
            System.out.println("addressSize=" + unsafe.addressSize());
            //获取操作系统的缓存页大小
            System.out.println("pageSize=" + unsafe.pageSize());
            User user = (User) unsafe.allocateInstance(User.class);
            User user1 = new User(1);
            //Unsafe实例化对象
            System.out.println(user.getA());
            System.out.println(user1.getA());

        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            System.out.println("没找到theUnsafe属性。");
        }
    }

    @Data
    static class User {
        public int a;

        User(int a) {
            this.a = 10;
        }
    }

    @Test
    public void test2() throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        IntStream.range(0, 100)// 起100个线程，每个线程自增10000次
                .forEach(i -> threadPool.submit(
                        () -> IntStream.range(0, 10000).forEach(j -> counter.increment()))
                );
        threadPool.shutdown();
        Thread.sleep(2000);
        // 打印1000000
        System.out.println(counter.getCount());
    }

    static class Counter {
        private volatile int count = 0;
        private static long offset;
        private static Unsafe unsafe;

        static {
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                unsafe = (Unsafe) f.get(null);
                //获取属性count在类Counter的内存偏移地址
                offset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("count"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public void increment() {
            int before = count;
            // 失败了就重试直到成功为止
            while (!unsafe.compareAndSwapInt(this, offset, before, before + 1)) {
                before = count;
            }
        }

        public int getCount() {
            return count;
        }
    }


}
