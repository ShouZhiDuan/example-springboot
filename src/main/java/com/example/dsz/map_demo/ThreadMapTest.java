package com.example.dsz.map_demo;

import lombok.Data;

import java.util.HashMap;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/25 21:29
 * @Description:
 */
@Data
public class ThreadMapTest {
    private static HashMap<String,String> map = new HashMap();
    public static void main(String[] args) throws InterruptedException {
          new Thread(()->{
               for (int i=0;i<1000;i++){
                   map.put("key"+i,"value");
               }
          },"Thread-1").start();
          new Thread(()->{
              for (int i=1000;i<2000;i++){
                  map.put("key"+i,"value");
              }
          },"Thread-2").start();
          Thread.sleep(5000);
          System.out.println("map.size=" + map.size());
    }
}
