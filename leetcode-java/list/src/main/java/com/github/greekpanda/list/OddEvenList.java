package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Odd Even Linked List
 * 描述
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we
 * are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(n) time
 * complexity.
 * Example:
 * Given 1->2->3->4->5->NULL ,
 * return 1->3->5->2->4->NULL .
 * Note:
 * 1. The relative order inside both the even and odd groups should remain as it was in the input.
 * 2. The first node is considered odd, the second node even and so on ...
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/25 21:35
 */
@Slf4j
public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;

        ListNode ret = oddEvenList(head);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode listOdd = new ListNode(0);
        ListNode listEven = new ListNode(0);

        ListNode odd = listOdd;
        ListNode even = listEven;

        int index = 1;
        while(head != null) {
            if(index % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            index++;
        }
        odd.next = listEven.next;
        return listOdd.next;


    }
}
