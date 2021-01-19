package com.example.dsz.lambda;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/12 16:11
 * @Description:
 */
public class LambdaMainTest extends LambdaMainSuper{

    private static int a;

    private int b;

    private final  LambdaMainTest test = new LambdaMainTest();

    {
        System.out.println("子类-实例构造器");
    }
    static {
        System.out.println("子类-类构造器");
    }

    public LambdaMainTest() {
        System.out.println("子类-无参构造函数");
    }

    public static void main(String[] args) {
          new LambdaMainTest();
    }


}
