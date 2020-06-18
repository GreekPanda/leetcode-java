package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 描述
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 08:46
 */
@Slf4j
public class ConstructTreeWithPreOrderAndInOrder {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null)
            return null;

        return buildTree(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }

    private static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart == preEnd)
            return null;

        if (inStart == inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootPos = find(inOrder, inStart, inEnd, preOrder[preStart]);
        int leftPos = rootPos - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftPos + 1,
                inOrder, inStart, inStart + leftPos);
        root.right = buildTree(inOrder, preStart + leftPos + 1, preEnd,
                inOrder, rootPos + 1, inEnd);

        return root;

    }

    private static int find(int[] arr, int begin, int end, int val) {
        for (int i = begin; i < end; i++) {
            if (arr[i] == val)
                return i;
        }
        return Integer.MAX_VALUE;
    }
}
