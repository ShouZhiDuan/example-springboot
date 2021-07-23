package com.example.dsz.atomic;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 11:46
 * @Description:
 */
@Data
public class Test2 {
    public int a;
    public final int b = 0;
    static int c;
    public static String d = "test";
//    public static void main(String[] args) {
//        Test2 test2 = new Test2();
//    }


    public static void test2() {
        Test2 test2 = new Test2();
    }

}
