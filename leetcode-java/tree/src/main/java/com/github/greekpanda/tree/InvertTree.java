package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Invert Binary Tree
 * 描述
 * Invert a binary tree.
 * 4
 * / \
 * 2 7
 * / \ / \
 * 1 3 6 9
 * to
 * 4
 * / \
 * 7 2
 * / \ / \
 * 9 6 3 1
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 14:06
 */
@Slf4j
public class InvertTree {
    public static void main(String[] args) {
        Integer[] preOrderArray = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        TreeNode result = invertRecursive(root);
        log.info(String.valueOf(result));
        TreeNode treeNode = invert(root);
        log.info(String.valueOf(treeNode));
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = root;
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                q.offer(node.left);

            if (node.right != null)
                q.offer(node.right);
        }
        return root;
    }

    public static TreeNode invertRecursive(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = invertRecursive(root.right);
        root.right = tmp;

        return root;
    }
}
