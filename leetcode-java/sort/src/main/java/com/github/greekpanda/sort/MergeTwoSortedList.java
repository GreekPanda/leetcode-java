package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 08:16
 */
@Slf4j
public class MergeTwoSortedList {
    public static void main(String[] args) {

    }

    public ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        ListNode p = dummy;

        for (; head1 != null && head2 != null; p = p.next) {
            if (head1.val > head2.val) {
                p.next = head2;
                head2 = head2.next;
            } else {
                p.next = head1;
                head1 = head1.next;
            }
        }

        p.next = head1 != null ? head1 : head2;

        return dummy.next;

    }
}
