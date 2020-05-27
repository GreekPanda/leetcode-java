package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

/**
 * Linked List Cycle
 * 描述
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * 分析
 * 最容易想到的方法是，用一个哈希表 unordered_map<int, bool> visited ，记录每个元素是否被访问
 * 过，一旦出现某个元素被重复访问，说明存在环。空间复杂度 O(n) ，时间复杂度 O(N) 。
 * 最好的方法是时间复杂度 O(n) ，空间复杂度 O(1) 的。设置两个指针，一个快一个慢，快的指针每次走
 * 两步，慢的指针每次走一步，如果快指针和慢指针相遇，则说明有环。参考\myurl{
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 09:31
 */
@Slf4j
public class ListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode p = head.next;
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        //构成环状
        head.next.next.next.next.next = p;

        boolean ret = isCycle(head);
        log.info(String.valueOf(ret));
    }

    public static boolean isCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
