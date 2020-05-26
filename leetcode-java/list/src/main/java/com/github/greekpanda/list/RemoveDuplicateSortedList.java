package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Remove Duplicates from Sorted List
 * 描述
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2 , return 1->2 .
 * Given 1->1->2->3->3 , return 1->2->3 .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 09:45
 */
@Slf4j
public class RemoveDuplicateSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = null;

        long start = System.currentTimeMillis();
        ListNode ret1 = removeDuplicateFromSortedList(head);
        long end = System.currentTimeMillis();
        log.info(String.valueOf(end - start));
        while (ret1 != null) {
            log.info(String.valueOf(ret1.val));
            ret1 = ret1.next;
        }

        log.info("--------------------");
        long start1 = System.currentTimeMillis();
        ListNode ret2 = removeDuplicateFromSortedListRecursive(head);
        long end1 = System.currentTimeMillis();
        log.info(String.valueOf(end1 - start1));
        while (ret2 != null) {
            log.info(String.valueOf(ret2.val));
            ret2 = ret2.next;
        }
    }

    public static ListNode removeDuplicateFromSortedList(ListNode head) {
        if (head == null || head.next == null)
            return null;

        for (ListNode prev = head, cur = head.next; cur != null; cur = cur.next) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }

    public static ListNode removeDuplicateFromSortedListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return null;

        //构造一个与头节点不一样数值的哑几点
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        recur(dummy, head);
        return dummy.next;
    }

    private static void recur(ListNode dummy, ListNode head) {
        if (head == null)
            return;

        if (dummy.val == head.val) {
            dummy.next = head.next;
            recur(dummy, head.next);
        } else {
            recur(dummy.next, head.next);
        }
    }
}
