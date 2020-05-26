package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;


/**
 * 描述
 * Given a linked list, remove the n -th node from the end of list and return its head.
 * For example, Given linked list: 1->2->3->4->5 , and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5 .
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 分析
 * 设两个指针 p , q ，让 q 先走 n 步，然后 p 和 q 一起走，直到 q 走到尾节点，删除 p->next 即可
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 22:49
 */
@Slf4j
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        int k = 2;
        ListNode ret = removeNthFromEnd(head, k);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null && head.next == null)
            return null;

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for(int i = 0; i < n; i++) {
            q = q.next;
        }

        while(q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;

        return dummy.next;

    }
}
