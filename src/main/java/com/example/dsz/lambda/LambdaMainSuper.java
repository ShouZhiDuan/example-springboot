package com.example.dsz.lambda;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/12 16:11
 * @Description:
 */
public class LambdaMainSuper {


    {
        System.out.println("父类-实例构造器");
    }

    static {
        System.out.println("父类-类构造函器");
    }


    public LambdaMainSuper() {
        System.out.println("父类-无参构造函数");
    }
}
