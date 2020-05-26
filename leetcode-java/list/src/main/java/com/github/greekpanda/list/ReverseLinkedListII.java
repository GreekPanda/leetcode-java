package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Reverse Linked List II
 * 描述
 * Reverse a linked list from position m to n . Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->nullptr , m = 2 and n = 4,
 * return 1->4->3->2->5->nullptr .
 * Note: Given m , n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 09:17
 */
@Slf4j
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        ListNode ret = reverseLinkedList(head, 2, 4);
        while (ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }
    }

    public static ListNode reverseLinkedList(ListNode head, int m, int n) {
        if (head == null || head.next == null || m > n)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode head2 = prev;
        prev = head2.next;

        ListNode cur = prev.next;
        for (int i = m; i < n; ++i) {
            prev.next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = prev.next;
        }
        return dummy.next;
    }
}
