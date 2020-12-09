package com.example.dsz.t_fanxin;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 9:57
 * @Description:
 */
@Data
public class Ttest1 {

    private int lev;

    class Cat{
        private String name;
    }

    static class Animals{
        private int leg;
    }

    class Dog extends Animals{
        private String color = lev+"";
    }

    private static int countLegs(List<Animals> animals){
        System.out.println("to do List<Animals> animals");
        return 2;
    }

    private static int countLegs1(List<? extends Animals> animals){
        System.out.println("to do List<? extends Animals> animals");
        return 2;
    }

    public static void main(String[] args) {
//        List<Animals> animals = new ArrayList<>();
//        List<Dog> dogs = new ArrayList<>();
//        countLegs(animals);
//        countLegs1(dogs);
//        TestDo testDo = new TestDo();
//        testDo.age=1;
//        Cat cat = new Ttest1().new Cat();
//        DeafaultClass.JsonData jsonData1 = new DeafaultClass().new JsonData();
        Class<DeafaultClass.JsonData> jsonDataClass = DeafaultClass.JsonData.class;
        Class<DeafaultClass> deafaultClassClass = DeafaultClass.class;
        Constructor<?>[] constructors = deafaultClassClass.getConstructors();
        for(Constructor constructor : constructors){
            String name = constructor.getName();
            System.out.println("构造函数名称：" + name);
            System.out.println("构造函数：" + constructor);

        }
    }


}
