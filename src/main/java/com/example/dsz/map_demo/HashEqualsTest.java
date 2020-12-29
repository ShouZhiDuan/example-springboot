package com.example.dsz.map_demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/25 14:14
 * @Description:
 */
@Data
@AllArgsConstructor
public class HashEqualsTest {
    private int age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashEqualsTest that = (HashEqualsTest) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
//        System.out.println("======名字不同======");
//        HashEqualsTest dsz1 = new HashEqualsTest(1, "dsz1");
//        HashEqualsTest dsz2 = new HashEqualsTest(1, "dsz2");
//        System.out.println("dsz1#hashCode=" + dsz1.hashCode());
//        System.out.println("dsz2#hashCode=" + dsz2.hashCode());
//        System.out.println("dsz1.equals(dsz2)=" + dsz1.equals(dsz2));
//        System.out.println("======名字相同======");
//        HashEqualsTest dsz3 = new HashEqualsTest(1, "dsz1");
//        HashEqualsTest dsz4 = new HashEqualsTest(1, "dsz1");
//        System.out.println("dsz3#hashCode=" + dsz3.hashCode());
//        System.out.println("dsz4#hashCode=" + dsz4.hashCode());
//        System.out.println("dsz3.equals(dsz4)=" + dsz3.equals(dsz4));

        HashMap<Object, Object> map = new HashMap<>();
        map.put(11,"test");
    }
}
