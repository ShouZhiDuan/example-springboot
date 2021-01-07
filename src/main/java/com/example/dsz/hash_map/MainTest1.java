package com.example.dsz.hash_map;

import java.util.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/6 14:34
 * @Description:
 */
public class MainTest1 {

    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(new Object());


        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        objectObjectTreeMap.put(1,"a");
        objectObjectTreeMap.put(3,"b");
        objectObjectTreeMap.put(2,"c");

        Set<Map.Entry<Object, Object>> entries = objectObjectTreeMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries){
            System.out.println(entry.getKey());
        }

        Arrays.sort(new ArrayList().toArray(), new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {

                return 0;
            }
        });
        Collections.sort(new ArrayList(),new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });


        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(3);
        objects.add(2);
        objects.sort((Integer t1, Integer t2) -> {
            return  t1-t2;
        });
        System.out.println();
    }

}
