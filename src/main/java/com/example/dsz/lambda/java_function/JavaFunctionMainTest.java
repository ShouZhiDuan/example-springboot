package com.example.dsz.lambda.java_function;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/15 15:43
 * @Description:
 */
public class JavaFunctionMainTest {

    /**
     * Function
     */
    public static String testFunction(String a,Function<String,String> function) {
        return   function.apply(a);
    }

    /**
     * Predicate
     */
    public static boolean testPredict(String targ){
        Predicate<String> predicate =  a -> a.startsWith("2");
        return predicate.test(targ);
    }



    public static void main(String[] args) {
        System.out.println(testFunction("apply", a->a+"c"));
        Function function =  a -> a+"test";
        System.out.println(function.apply("Hello "));
        System.out.println(testPredict("2666666"));
    }


}
