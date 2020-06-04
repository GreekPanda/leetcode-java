package com.github.greekpanda.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 1.如果一个接口只有一个抽象接口，此即满足函数是接口
 * 2.如果加上了FunctionalInterface, 编译器将此接口当做函数式接口
 * 3.如果某个接口只有一个抽象方法，但是并没有给这个接口声明functionalInterface，此接口也会被编译器当做函数式接口
 * 即是否加上FunctionalInterface加与否不影响此接口成为函数式接口
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/30 07:25
 */
@Slf4j
public class FirstTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //Consumer就是一个显示声明的函数式接口
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + "\t");
            }
        });
        System.out.println();

        FirstTest firstTest = new FirstTest();
        firstTest.myInterfaceTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("MyInterface test");
            }
        });

        System.out.println("-----use lambda----");


        //use lambda
        firstTest.myInterfaceTest(() -> {
            System.out.println("mytest");
            System.out.println(firstTest.getClass());
        });


        //use Lambda to print list

        System.out.println("---for each lambda");
        list.forEach(i -> {
            System.out.print(i + "\t");
        });

        list.forEach(System.out::print);

    }

    public void myInterfaceTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }
}
