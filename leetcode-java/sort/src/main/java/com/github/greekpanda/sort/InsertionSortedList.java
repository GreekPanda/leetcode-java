package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Insertion Sort List
 * 描述
 * Sort a linked list using insertion sort
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 08:03
 */
@Slf4j
public class InsertionSortedList {
    public static void main(String[] args) {

    }


    public static ListNode insertionSortedList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        for (ListNode cur = head; cur != null; ) {
            ListNode pos = findPos(head, cur.val);
            ListNode tmp = cur.next;

            cur.next = pos.next;
            pos.next = cur;
            cur = tmp;

        }

        return dummy.next;

    }

    private static ListNode findPos(ListNode head, int x) {
        ListNode pre = null;

        for (ListNode cur = head; cur != null && cur.val < x; pre = cur, cur = cur.next) {
            ;
        }

        return pre;
    }
}
