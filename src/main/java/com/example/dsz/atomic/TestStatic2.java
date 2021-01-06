package com.example.dsz.atomic;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 12:03
 * @Description:
 */
public class TestStatic2 {

       public void testDo(){
           //静态变量 类直接访问
           System.out.println(TestStatic.a + TestStatic.b);
           TestStatic testStatic = new TestStatic();
           System.out.println(testStatic.c);
           testStatic.test2();
           TestStatic.test3();
       }

    public static void main(String[] args) {
        TestStatic testStatic = new TestStatic();
        testStatic.b=2;
        List<Integer> list = testStatic.list;
        list.add(6);
        //testStatic.list= Arrays.asList(2);
    }

}
