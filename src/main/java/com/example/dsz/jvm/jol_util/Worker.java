package com.example.dsz.jvm.jol_util;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/14 15:36
 * @Description:
 */
public class Worker {

    private int age;

    private String name;

    public static void printf(Worker worker){
        // 查看对象的整体结构信息 // JOL工具类
        System.out.println(ClassLayout.parseInstance(worker).toPrintable());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
