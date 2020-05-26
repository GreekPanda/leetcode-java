package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Partition List
 * 描述
 * Given a linked list and a value x , partition it such that all nodes less than x come before nodes
 * greater than or equal to x .
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example, Given 1->4->3->2->5->2 and x = 3 , return 1->2->2->4->3->5 .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 09:30
 */
@Slf4j
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = null;

        ListNode ret = partitionList(head, 3);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }

    }

    public static ListNode partitionList(ListNode head, int x) {
        if(head == null | head.next == null || x < 0)
            return null;

        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);

        ListNode leftCur = leftDummy;
        ListNode rightCur = rightDummy;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            if(cur.val < x) {
                leftCur.next = cur;
                leftCur = cur;
            } else {
                rightCur.next = cur;
                rightCur = cur;
            }
        }
        leftCur.next = rightDummy.next;
        rightCur.next = null;

        return leftDummy.next;
    }
}
