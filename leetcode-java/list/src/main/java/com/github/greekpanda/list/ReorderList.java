package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 *Reorder List
 * 描述
 * Given a singly linked list L : L → L → ⋯ → L → L , reorder it to:
 * L → L → L → L → L → L → ⋯
 * You must do this in-place without altering the nodes' values.
 * For example, Given {1,2,3,4} , reorder it to {1,4,2,3} .
 * 分析
 * 题目规定要in-place，也就是说只能使用 O(1) 的空间。
 * 可以找到中间节点，断开，把后半截单链表reverse一下，再合并两个单链表
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 09:51
 */
@Slf4j
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ret = reOrder(head);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }
    }

    public static ListNode reOrder(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        slow = reverse(slow);

        ListNode cur = head;
        while(cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = slow;
            slow = slow.next;
            cur.next.next = tmp;
            cur = tmp;
        }
        cur.next = slow;

        return cur;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode prev = head;
        for(ListNode cur = head.next, next = cur.next;
            cur != null;
            prev = cur, cur = next, next = next != null ? next.next : null) {
            cur.next = prev;

        }
        head.next = null;
        return prev;
    }
}
