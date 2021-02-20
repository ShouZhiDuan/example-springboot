package com.example.dsz.annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/19 18:01
 * @Description: https://hellofrank.github.io/2019/09/05/Java%E6%B3%A8%E8%A7%A3%E8%AF%A6%E8%A7%A3/
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    String name() default "ShouZhi@Duan";

}
