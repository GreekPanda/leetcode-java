package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Remove Duplicates from Sorted List II
 * 描述
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5 , return 1->2->5 .
 * Given 1->1->1->2->3 , return 2->3 .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 10:03
 */
@Slf4j
public class RemoveDuplicateSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = null;

        ListNode ret1 = removeDuplicateFromSortedList(head);
        while(ret1 != null) {
            log.info(String.valueOf(ret1.val));
            ret1 = ret1.next;
        }
        log.info("------------------");
        ListNode ret2 = removeDuplicateFromSortedListRecursive(head);
        while(ret2 != null) {
            log.info(String.valueOf(ret2.val));
            ret2 = ret2.next;
        }

    }

    public static ListNode removeDuplicateFromSortedList(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            boolean duplicated = false;
            while (cur.next != null && cur.val == cur.next.val) {
                duplicated = true;
                cur = cur.next;
            }
            if(duplicated) {
                cur = cur.next;
                continue;
            }
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = cur;

        return dummy.next;
    }

    public static ListNode removeDuplicateFromSortedListRecursive(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode p = head.next;
        if(head.val == p.val) {
            while(p != null && p.val == head.val) {
                p = p.next;
            }
            return removeDuplicateFromSortedListRecursive(p);
        } else {
            head.next = removeDuplicateFromSortedListRecursive(head.next);
            return head;
        }
    }

}
