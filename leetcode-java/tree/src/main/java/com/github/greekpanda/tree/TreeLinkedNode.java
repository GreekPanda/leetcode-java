package com.github.greekpanda.tree;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:42
 */
public class TreeLinkedNode {
    int val;
    TreeLinkedNode left;
    TreeLinkedNode right;
    TreeLinkedNode next;

    TreeLinkedNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
