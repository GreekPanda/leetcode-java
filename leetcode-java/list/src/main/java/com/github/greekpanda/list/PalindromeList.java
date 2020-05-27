package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Palindrome Linked List
 * 描述
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 分析
 * 首先要寻找中点，原理是使用快慢指针，每次快指针走两步，慢指针走一步。同时还要用栈，每次慢指针
 * 走一步，都把值存入栈中。等快指针走完时，链表的前半段都存入栈中了。最后慢指针继续往前走，每次
 * 与栈顶元素进行比较。空间复杂度 O(n) 。
 * 如何做到用 O(1) 空间呢？可以先找到中点，把后半段reverse一下，然后比较两个小链表。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 10:14
 */
@Slf4j
public class PalindromeList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        boolean ret = isPalindrome(head);
        log.info(String.valueOf(ret));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return false;

        final ListNode mid = findMid(head);
        mid.next = reverse(mid.next);

        ListNode p1 = head.next;
        ListNode p2 = mid.next;
        while(p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }

    private static ListNode findMid(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
