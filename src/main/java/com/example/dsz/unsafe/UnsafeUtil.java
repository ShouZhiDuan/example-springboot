package com.example.dsz.unsafe;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 14:48
 * @Description:
 */
@Data
public class UnsafeUtil {

    private static final int INT = 4;

    private long size;

    private long address;

    private static Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 构造方法，分配内存
    public UnsafeUtil(long size) {
        this.size = size; //设置元素个数
        address = unsafe.allocateMemory(size * INT);//预设操作的总内存大小
    }

    public UnsafeUtil() {
    }

    // 获取指定索引处的元素
    public int get(long i) {
        return unsafe.getInt(address + i * INT);
    }

    // 设置指定索引处的元素
    public void set(long i, int value) {
        unsafe.putInt(address + i * INT, value);
    }

    // 元素个数
    public long size() {
        return size;
    }

    // 释放堆外内存
    public void freeMemory() {
        unsafe.freeMemory(address);
    }

}
