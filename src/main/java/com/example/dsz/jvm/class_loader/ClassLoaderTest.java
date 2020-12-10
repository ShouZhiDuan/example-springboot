package com.example.dsz.jvm.class_loader;

import com.example.dsz.jvm.Person;
import lombok.Data;

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
    public static void main(String[] args) {
//        ClassLoader classLoader = Person.class.getClassLoader();
//        System.out.println(classLoader);

        System.out.println(String.class.getClassLoader());
    }




}
