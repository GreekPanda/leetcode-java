package com.github.greekpanda.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * 描述
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from
 * top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by
 * using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called
 * on an empty queue)
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/11 08:42
 */
@Slf4j
public class QueueUsingStack {
    private static Stack s = new Stack<>();
    private static Stack tmp = new Stack<>();

    public static void main(String[] args) {

    }

    public static void push(int x) {
        while (!s.isEmpty()) {
            final int e = (int) s.pop();
            tmp.push(e);
        }
        tmp.push(x);

        while (!tmp.isEmpty()) {
            final int e = (int) tmp.pop();
            s.push(e);
        }
    }

    public static void pop() {
        s.pop();
    }

    public static int peek() {
        return (int) s.peek();
    }

    public static boolean isEmpty() {
        return s.isEmpty();
    }



}
