package com.example.dsz.jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 10:05
 * @Description:
 */
public class Person {
    public int age;//实例变量
    public int age1 = 10;//实例变量
    public String name;//实例变量
    public String name1 = "duanshouzhi";//常量
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

    public static void main(String[] args) {
        /**
         * 字符串常量 to see https://www.cnblogs.com/niew/p/9597379.html
         * 基本数据包装类型常量
         * 类信息字面量常量、静态数据、final常量
         */
         String a = "test";
         String b = "test";
         String c = new String("test");
         String d = new String("test");
         System.out.println(a==b);
         System.out.println(a==c);
         System.out.println(c==d);
    }
}
