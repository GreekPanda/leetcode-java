package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 描述
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 09:02
 */
@Slf4j
public class ConstructTreeWithInOrderAndPostOrder {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (postOrder == null || inOrder == null)
            return null;

        return buildTree(inOrder, 0, inOrder.length, postOrder, 0, postOrder.length);
    }

    private static TreeNode buildTree(int[] inOrder, int inStart, int inEnd,
                                      int[] postOrder, int postStart, int postEnd) {
        if (postStart == postEnd)
            return null;

        if (inStart == inEnd)
            return null;

        int val = postOrder[postEnd - 1];
        TreeNode root = new TreeNode(val);

        int rootPos = find(inOrder, inStart, inEnd, val);
        int leftSize = rootPos - inStart;
        int postLeftLast = postStart + leftSize;

        root.left = buildTree(inOrder, inStart, leftSize, postOrder, postStart, postLeftLast);
        root.right = buildTree(inOrder, rootPos + 1, inEnd, postOrder, postLeftLast, postEnd - 1);
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
