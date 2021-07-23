package com.example.dsz.hash_map;

import java.util.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/5 18:32
 * @Description:
 */

public class HashMapMainTest {

    public static final int a = 0;

    public static void main(String[] args) {
//        test1();
//        test2();
//        String[] sts = {""};
//        String[] sts2 = new String[6];
//        ArrayList<Object> objects = new ArrayList<>();
//        objects.add(1);

//        new HashMap<>(Math.max((int) (10/.75f) + 1, 16));
//        System.out.println((75/.75f));
//        System.out.println("较大=" + Math.max(10,6));
//        System.out.println("较小=" + Math.min(10,6));


//        Vector<Object> vector = new Vector<>();
//        vector.add(1);
//        vector.addElement(1);


        HashMap<Object, Object> map = new HashMap<>(32, 1);
//        int i = 1;
//        do {
//            map.put(i+"ab",i);
//            i++;
//        }while (i <= 20);

//        map.put(18+"ab",1);

//        hash=1514769
//        key=1ab
//        18
//        hash=50194
//        key=15ab
//        18

        map.put("15ab", 1);
        map.put("1ab", 1);


        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        for (Map.Entry<Object, Object> entry : entries) {
            String key = (String) entry.getKey();
            System.out.println("key=" + key);
            //System.out.println("key="+entry.getKey());
            //System.out.println("value="+entry.getValue());
            //System.out.println("key-hash="+(key.hashCode()^(key.hashCode()>>>16)));
            //System.out.println("key-hashcode="+key.hashCode());
            //System.out.println("0".hashCode());
            int h;
            int hash = (h = key.hashCode()) ^ (h >>> 16);
            System.out.println(hash & (32 - 1));
            System.out.println("hash=" + hash);
        }

        Collection<Object> values = map.values();


    }

    public static void test1() {
        long l1 = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        map.put("test1", "test1");
        long l2 = System.currentTimeMillis();
        System.out.println("test1=" + (l2 - l1));
    }

    public static void test2() {
        long l1 = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>(1 << 31, 1);
        map.put("test2", "test2");
        long l2 = System.currentTimeMillis();
        System.out.println("test2=" + (l2 - l1));
    }

}
