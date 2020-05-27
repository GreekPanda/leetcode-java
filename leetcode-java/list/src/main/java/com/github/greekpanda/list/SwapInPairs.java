package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Swap Nodes in Pairs
 * 描述
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4 , you should return the list as 2->1->4->3 .
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes
 * itself can be changed.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 22:59
 */
@Slf4j
public class SwapInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode ret = swapInPairs(head);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }

    }

    public static ListNode swapInPairs(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        //使用了三个指针
        for(ListNode prev = dummy, cur = prev.next, next = cur.next;
            next != null;
            prev = cur, cur = cur.next, next = cur != null ? cur.next : null) {

            prev.next = next;
            cur.next = next.next;
            next.next = cur;
        }

        return dummy.next;
    }
}
