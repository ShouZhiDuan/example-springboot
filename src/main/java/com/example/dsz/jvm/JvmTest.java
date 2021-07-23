package com.example.dsz.jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 13:26
 * @Description:
 */
public class JvmTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.example.dsz.jvm.Person");
        //new Person();
    }

    public void test() {
        System.out.println();
    }

}
