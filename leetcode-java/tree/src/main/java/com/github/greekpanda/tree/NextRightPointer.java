package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:40
 */
@Slf4j
public class NextRightPointer {
    public static void main(String[] args) {

    }

    public static void connect(TreeLinkedNode root) {
        connect(root, null);
    }

    private static void connect(TreeLinkedNode root, TreeLinkedNode sibling) {
        if (root == null)
            return;
        else
            root.next = sibling;

        connect(root.left, root.right);
        if (sibling != null) {
            connect(root.right, sibling.next);
        } else {
            connect(root.right, null);
        }

    }
}
