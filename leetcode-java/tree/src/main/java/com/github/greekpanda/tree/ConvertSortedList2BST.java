package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 09:00
 */
@Slf4j
public class ConvertSortedList2BST {
    public static void main(String[] args) {

    }

    public static TreeNode sortedList2BST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode mid = middle(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedList2BST(head);
        root.right = sortedList2BST(mid.next);

        return root;
    }

    private static ListNode middle(ListNode head) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = head;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow = null;

        return slow;
    }
}
