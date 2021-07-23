package com.example.dsz.java_spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 17:43
 * @Description:
 */
public class SpiMainTest {
    /**
     * SPI动态类加载测试
     */
    public static void main(String[] args) {
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()) {
            iterator.next().syaHello();
        }
    }
}
