package com.example.dsz.jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 10:05
 * @Description:
 */
public class Person {
    private int age;
    private int age1 = 10;
    private String name;
    private String name1 = "duanshouzhi";
    private static String banji;
    private static String school = "xuexiao";
    private final static String addr = "zhuzhi";
    private final String city;
    private final String province = "shenfen";

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
