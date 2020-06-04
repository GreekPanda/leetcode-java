package com.github.greekpanda.java8;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/1 15:50
 */
public class Test3Function {
    public static void main(String[] args) {

        Interface1 i1 = () -> {};
        System.out.println(i1.getClass().getInterfaces()[0]);

        //Interface has to be initialized as lambda
        //匿名方式使用进行初始化
        //Interface2 i2 = () -> {};
        Interface2 i2 = new Interface2() {
            @Override
            public void interface2Method() {

            }
        };
        System.out.println(i2.getClass().getInterfaces()[0]);

        System.out.println("runnable interface");

        new Thread( () -> {
            System.out.println("main thread running");
        }).start();
    }
}

@FunctionalInterface
interface Interface1 {
    void interface1Method();
}

@FunctionalInterface
interface Interface2 {
    void interface2Method();
}
