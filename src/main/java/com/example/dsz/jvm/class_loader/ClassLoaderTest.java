package com.example.dsz.jvm.class_loader;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 14:16
 * @Description:
 */
@Data
public class ClassLoaderTest {

    /**
     * Bootstrap -> Extention -> App -> Custom
     */
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        Class<?> aClass = classLoader.loadClass("java.lang.String");
//        System.out.println(aClass.getClassLoader());

        URL resource = ClassLoaderTest.class.getResource("/com/example/dsz/jvm/class_loader/");
        //new FileInputStream(resource);
        URL resource1 = ClassLoaderTest.class.getClassLoader().getResource("");
        System.out.println(resource);
        System.out.println(resource1);

    }




}
