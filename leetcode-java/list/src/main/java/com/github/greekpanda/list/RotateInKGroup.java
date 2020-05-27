package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Reverse Nodes in k-Group
 * 描述
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example, Given this linked list: 1->2->3->4->5
 * For k = 2 , you should return: 2->1->4->3->5
 * For k = 3 , you should return: 3->2->1->4->5
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 23:07
 */
@Slf4j
public class RotateInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        int k = 2;
        ListNode ret = reverseKGroup(head, 2);
        while (ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }

    }

//    public static ListNode rotateInKGroup(ListNode head, int k) {
//        if(head == null || head.next == null || k < 2)
//            return null;
//
//        ListNode dummy = new ListNode(Integer.MAX_VALUE);
//        dummy.next = head;
//
//        for(ListNode prev = dummy, end = head; end != null; end = prev.next) {
//            for(int i = 1; i < k && end != null; i++) {
//                end = end.next;
//                if(end == null)
//                    break;
//            }
//            prev = reverse(prev, prev.next, end);
//        }
//        return dummy.next;
//
//    }
//
//    private static ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
//        ListNode endNext = end.next;
//        for(ListNode p = begin, cur = p.next, next = cur.next;
//            cur != endNext;
//            p = cur, cur = next, next = next != null ? next.next : null) {
//            cur.next = p;
//        }
//        begin.next = endNext;
//        prev.next = end;
//        return begin;
//    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode prev = dummy, end = head; end != null; end = prev.next) {
            for (int i = 1; i < k && end != null; i++)
                end = end.next;
            if (end == null) break; // 不足 k 个
            prev = reverse(prev, prev.next, end);
        }
        return dummy.next;
    }

    // prev 是 first 前一个元素, [begin, end] 闭区间，保证三者都不为 null
    // 返回反转后的倒数第1个元素
    private static ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
        ListNode end_next = end.next;
        for (ListNode p = begin, cur = p.next, next = cur.next;
             cur != end_next;
             p = cur, cur = next, next = next != null ? next.next : null) {
            cur.next = p;
        }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }
}
