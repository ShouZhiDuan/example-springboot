package com.example.dsz.jvm.do_test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/7 11:20
 * @Description:
 */
public class JvmTestDo implements JvmInterface {

    private String privateName = "privateName";
    public int intB = 1;
    public static int intC = 2;
    private static String staticStringNul;
    public static String staticStringName = "staticName";
    private static JvmTestDo jvmTestDo = new JvmTestDo();
    public final int finalIntC = 1;
    public final static int finalIntD = 1;
    public final String finalString = "finalString";
    public final static String finalStaticString = "finalStaticString";


    static void testDo(int b) {
        int c;
        c = intC + 1;
        System.out.println(c);
        System.out.println(b);
    }

    public static void main(String[] args) {
        testDo(6);
    }

    @Override
    public void test() {
        System.out.println();
    }
}
