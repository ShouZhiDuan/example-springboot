package com.example.dsz.hash_equals;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/23 13:43
 * @Description:
 */
@Data
@AllArgsConstructor
public class TestHashEqual {
    private int age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestHashEqual that = (TestHashEqual) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public static void main(String[] args) {
        TestHashEqual dsz1 = new TestHashEqual(1, "dsz");
        TestHashEqual dsz2 = new TestHashEqual(1, "dsz");
        System.out.println(dsz1==dsz2);

        Class<TestHashEqual> testHashEqualClass = TestHashEqual.class;
        System.out.println(testHashEqualClass);
        System.out.println(dsz1.getClass());
        System.out.println(dsz2.getClass());

        System.out.println("equals=" + dsz1.equals(dsz2));

        /**
         * Set集合底层是根据Equals方式来判断两个对象是都相等的
         * 底层是个HashMap
         */
        Set<TestHashEqual> set = new HashSet<>();
        set.add(dsz1);
        set.add(dsz2);
        System.out.println(set.size());
        System.out.println(dsz1.hashCode());
        System.out.println(dsz2.hashCode());


        /**
         * 简介的说明HashMap的key判断时候重复的机制是：
         * 1、先判断key的hashCode是否一致
         * 2、在判断equals是否相等
         * 只有以上两者都相等才算key是同一个key.
         */
        HashMap<TestHashEqual, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(dsz1,1);
        objectObjectHashMap.put(dsz2,2);
        System.out.println();





    }



}
