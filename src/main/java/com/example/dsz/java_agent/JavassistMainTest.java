package com.example.dsz.java_agent;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/11 19:36
 * @Description:
 */
public class JavassistMainTest {
    public static void main(String[] args) throws NotFoundException {
        CtClass ctClass = null;
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(JavassistMainTest.class);
        pool.insertClassPath(classPath);
        ctClass = pool.get("com.example.dsz.java_agent.TimeTest");
        System.out.println(ctClass);
    }
}
