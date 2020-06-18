package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Flatten Binary Tree to Linked List
 * 描述
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, Given
 * 1
 * / \
 * 2 5
 * / \ \
 * 3 4 6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 08:34
 */
@Slf4j
public class FlattenTree {
    public static void main(String[] args) {

    }

    public static void flattenTree(TreeNode root) {
        if (root == null)
            return;

        flattenTree(root.left);
        flattenTree(root.right);

        if (root.left == null)
            return;

        TreeNode p = root.left;
        while (p.right != null)
            p = p.right;

        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void flattenTree1(TreeNode root) {
        if (root == null)
            return;

        flatten(root, null);
    }

    private static TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null)
            return tail;

        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;

    }
}
