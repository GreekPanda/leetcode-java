package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Rotate List
 * 描述
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->nullptr and k = 2 , return 4->5->1->2->3->nullptr .
 * 分析
 * 先遍历一遍，得出链表长度 len ，注意 k 可能大于 len ，因此令 k %= len 。将尾节点next指针指向首
 * 节点，形成一个环，接着往后跑 len-k 步，从这里断开，就是要求的结果了。
 * 代码
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/26 10:19
 */
@Slf4j
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;

        ListNode ret = rotateList(head, 3);
        while(ret != null) {
            log.info(String.valueOf(ret.val));
            ret = ret.next;
        }
    }

    public static ListNode rotateList(ListNode head, int k) {
        if(head == null || head.next == null || k < 0)
            return null;

        int len = 0;
        ListNode p = head;
        while(p.next != null) {
            len++;
            p = p.next;
        }

        k = len - k % len;
        p.next = head;
        for(int i = 0; i < k; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;

    }
}
