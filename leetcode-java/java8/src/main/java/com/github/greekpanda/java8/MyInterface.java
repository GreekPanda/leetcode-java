package com.github.greekpanda.java8;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/30 07:45
 */
@FunctionalInterface
public interface MyInterface {
    void test();
    //如果多个方法不允许使用FunctionInterface
    //void test1();

    //但是可以复写了object类，因此不会将抽象接口+1，所以此接口依然是函数式接口
    String toString();
}
