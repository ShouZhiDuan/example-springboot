package com.example.dsz.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 11:25
 * @Description: {@link java.util.concurrent.atomic.AtomicInteger}
 */

public class IntegerMainTest {

    private int value;

    public static long valueOffset = 0;

    static {
        try {
            valueOffset = getUnsafe().objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
            System.out.println(valueOffset);
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        boolean a = integer.compareAndSet(1, 2);
        System.out.println("a=" + a);
        //boolean b = integer.compareAndSet(1, 2);
        //System.out.println("b="+b);
        int i = integer.get();
        System.out.println(i);
        //返回当前回去的值，然后做原子减1
        int andDecrement = integer.getAndDecrement();
        System.out.println(integer.get());
    }


    public IntegerMainTest(int value) {
        this.value = value;
    }


    public static Unsafe getUnsafe() {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe = (Unsafe) declaredField.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("没找到theUnsafe属性。");
        }
    }


}
