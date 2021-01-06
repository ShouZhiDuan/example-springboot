package com.example.dsz.unsafe;

import lombok.Data;
import org.junit.Test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/31 15:00
 * @Description:
 */
@Data
public class JuniteTest {

    private int a;

//    public JuniteTest(int a){
//         this.a = a;
//    }

    public JuniteTest(){
    }

    @Test
    public void testDo(){
        UnsafeUtil offHeapArray = new UnsafeUtil(4);
        offHeapArray.set(0, 1);
        offHeapArray.set(1, 2);
        offHeapArray.set(2, 3);
        offHeapArray.set(3, 4);
        offHeapArray.set(2, 5); // 在索引2的位置重复放入元素
        int sum = 0;
        for (int i = 0; i < offHeapArray.size(); i++) {
            sum += offHeapArray.get(i);
        }
        System.out.println(sum);
        offHeapArray.freeMemory();
    }
}
