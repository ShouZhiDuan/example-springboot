package com.example.dsz.jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 10:05
 * @Description:
 */
public class Person {
    public int age;
    public int age1 = 10;
    public String name;
    public String name1 = "duanshouzhi";
    public static String banji;
    public static String school = "xuexiao";
    public final static String addr = "zhuzhi";
    public final String city;
    public final String province = "shenfen";

    {
        //只有实例化的时候被加载
        System.out.println("un static block");
    }

    static  {
        //实例化或者初始化的时候都会被加载
        System.out.println("is static block");
    }


    public Person(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public static String getBanji() {
        return banji;
    }

    public static void setBanji(String banji) {
        Person.banji = banji;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Person.school = school;
    }

    public static String getAddr() {
        return addr;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }
}
