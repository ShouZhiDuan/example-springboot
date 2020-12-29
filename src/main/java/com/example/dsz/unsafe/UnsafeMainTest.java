package com.example.dsz.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/29 16:13
 * @Description:
 */
public class UnsafeMainTest {

    public static void main(String[] args) {
        //强 软 弱 虚
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println();
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe = (Unsafe) declaredField.get(null);
            System.out.println("addressSize=" + unsafe.addressSize());//8
            System.out.println("pageSize=" + unsafe.pageSize());//4096
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("没找到theUnsafe属性。");
        }


    }

}
