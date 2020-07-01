package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * Merge k Sorted Lists
 * 描述
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 分析
 * 可以复用 Merge Two Sorted Lists 的函数
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/1 20:56
 */
@Slf4j
public class MergeKList {
    public static void main(String[] args) {

    }

    public static ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }

        ListNode p = lists[0];
        for (int i = 0; i < lists.length; i++) {
            p = mergeSortedList(p, lists[i]);
        }
        return p;
    }

    private static ListNode mergeSortedList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (; l1 != null && l2 != null; p = p.next) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
