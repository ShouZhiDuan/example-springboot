package com.example.dsz.jvm.jol_util;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/14 15:39
 * @Description:
 */
public class JolMainTest {
    public static void main(String[] args) {
          Worker worker = new Worker();
          Worker worker2 = new Worker();
          Worker.printf(worker);
          System.out.println("hash1=" + worker.hashCode());//1816089958->6c3f5566
          System.out.println("hash2=" + worker2.hashCode());//306206744->12405818
    }
}
