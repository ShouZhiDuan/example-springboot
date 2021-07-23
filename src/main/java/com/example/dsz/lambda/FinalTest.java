package com.example.dsz.lambda;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/12 21:51
 * @Description:
 */
public class FinalTest {

    private final FinalTest test = new FinalTest();

    public void setTest() {
        System.out.println("setTestMethod");
    }

    public void stringTest(String str) {
        String a = "a";
        String b = a + "b";
        System.out.println(a);
    }

    public void stringTest1(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = stringBuilder.append("a").append("b").toString();
        System.out.println(s);
    }

    public void stringTest3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = s1 + s2;
    }

}
