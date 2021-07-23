package com.example.dsz.t_fanxin;

import lombok.Data;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 16:59
 * @Description:
 */
@Data
public class TongPeiFu<E> {

    private E e;

    /**
     * 上界通配符
     * 通配符+返回值
     * 用 extends 关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。
     */
    public <K extends Ttest1, V extends Ttest1> K test(K k, V v) {
        return null;
    }

    /**
     * 下界通配符
     * 用 super 进行声明，表示参数化的类型可能是所指定的类型，或者是此类型的父类型，直至 Object
     */
    private <T> void test2(List<? super T> dst, List<T> src) {
        for (T t : src) {
            dst.add(t);
        }
    }

    /**
     * ？和 T 的区别
     * ？和 T 都表示不确定的类型，区别在于我们可以对 T 进行操作，但是对 ？不行，比如如下这种 ：
     */
    public void test3() {
        //T t = opration();//T可以作为变量
        //? t = opration();//？不可以作为变量
    }


}
