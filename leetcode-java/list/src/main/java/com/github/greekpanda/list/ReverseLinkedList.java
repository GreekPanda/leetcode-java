package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Reverse Linked List
 * 描述
 * Reverse a singly linked list.
 * 分析
 * 用三个指针 tail , p , q ，紧紧相邻，不断前进，每次将 p.next 指向 tail ，将 q.next 指向 p
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/25 17:03
 */
@Slf4j
public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode ret1 = reverseList(head);
        while (ret1.next != null) {
            log.info(String.valueOf(ret1.val));
            ret1 = ret1.next;
        }

        log.info("--------------------------");

        ListNode head1 = new ListNode(11);
        head1.next = new ListNode(21);
        head1.next.next = new ListNode(31);
        head1.next.next.next = new ListNode(41);
        head1.next.next.next.next = new ListNode(51);
        head1.next.next.next.next.next = new ListNode(61);
        head1.next.next.next.next.next.next = new ListNode(100);

        ListNode ret2 = reverseRecursive(head1);
        while (ret2.next != null) {
            log.info(String.valueOf(ret2.val));
            ret2 = ret2.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode tail = null;
        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {
            ListNode old = q.next;
            p.next = tail;
            q.next = p;

            tail = p;
            p = q;
            q = old;
        }
        return p;
    }

    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tail = head.next;
        head.next = null;
        ListNode newHead = reverseRecursive(tail);
        tail.next = head;

        return newHead;

    }
}
