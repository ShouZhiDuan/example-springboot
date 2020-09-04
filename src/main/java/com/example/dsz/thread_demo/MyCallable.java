package com.example.dsz.thread_demo;

import org.springframework.util.StringUtils;

import java.util.concurrent.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 14:51
 * @Description:
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("to do some things ......");
        Thread.sleep(3000);
        System.out.println("to do some things 2 ......");
        return "hello dsz";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        MyCallable callable = new MyCallable();
        Future<String> future = executorService.submit(callable);
        String s1 = "666666";
        try {
            //s1 = future.get(1, TimeUnit.MILLISECONDS);
            s1 = future.get();
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("超时");
        }
        executorService.shutdown();
    }


}
