package com.example.dsz.annotation_demo;

import java.lang.reflect.Field;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/20 9:47
 * @Description:
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            AnnotationMainTest test = new AnnotationMainTest();
            Class<? extends AnnotationMainTest> aClass = test.getClass();
            Field age = aClass.getDeclaredField("age");
            Field name = aClass.getDeclaredField("name");
            age.setAccessible(true);
            name.setAccessible(true);
            Object o1 = age.get(test);
            Object o2 = name.get(test);
            System.out.println(o1);
            System.out.println(o2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
