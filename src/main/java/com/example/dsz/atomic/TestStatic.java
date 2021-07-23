package com.example.dsz.atomic;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 12:03
 * @Description:
 */
public class TestStatic {

    public final static int a = 1;

    public static int b = 0;

    public int c;

    public final static List<Integer> list = Arrays.asList(1);


    public static void main(String[] args) {
        System.out.println();
        TestStatic testStatic = new TestStatic();
    }


    public void test2() {
        TestStatic testStatic = new TestStatic();
    }

    public static void test3() {
    }


}
