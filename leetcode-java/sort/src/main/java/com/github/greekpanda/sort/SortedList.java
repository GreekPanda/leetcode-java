package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Sort List
 * 描述
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 分析
 * 常数空间且 O(nlogn) ，单链表适合用归并排序，双向链表适合用快速排序。本题可以复用 Merge Two
 * Sorted Lists 的代码。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/1 21:04
 */
@Slf4j
public class SortedList {

    public static void main(String[] args) {
        int i = 0;
        int j = 10;
        do {
            if (i++ > j--)
                continue;
        } while (i < 5);
        System.out.println(i + " +i+ " + j);

        System.out.println("=======================");

        String s1 = "1";
        s1.intern();
        String s2 = "1";
        System.out.println(s1==s2);

        System.out.println("======================");
        int k = 0;
        for(foo('A'); foo('B') && k < 2; foo('C')) {
            foo('D');
            k++;
        }

        System.out.println("--------------------------");
        //corePoolSize：核心线程池大小
        //MaximumSize:最大线程数
        //keepAliveTime：存货时间
        //TimeUnit:时间单位
        //BlockingQueue:线程队列
        //ThreadFactory:线程工厂
        //RejectStrategy:拒绝策略:1) Abort 2) discard
//        ThreadPoolExecutor threadPoolExecutor = null;
//
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for(int i = 0; i < 5; i++) {
//            final int j = i;
//            executorService.execute(() -> {
//                System.out.println("thread name: " + Thread.currentThread().getName());
//            });
//
//        }
    }

    private static boolean foo(final char c) {
        System.out.println(c);
        return true;
    }


    public ListNode sortedList(ListNode head) {
        if (head == null || head.next == null)
            return null;

        final ListNode middle = findMiddle(head);
        final ListNode head2 = middle.next;

        middle.next = null;

        final ListNode l1 = sortedList(head);
        final ListNode l2 = sortedList(head2);

        return mergeTwoList(l1, l2);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        for (ListNode p = dummy; l1 != null && l2 != null; p = p.next) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (val1 <= val2) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        return dummy;
    }

    private static ListNode findMiddle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
