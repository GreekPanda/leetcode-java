package com.github.greekpanda.tree;

/**
 * Methods for constructing binary tree, including full binary tree
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/15 09:13
 */
public class ConstructBinaryTree {
    public static TreeNode constructByPreOrderArray(Integer[] preOrderArray) {
        if (preOrderArray == null || preOrderArray.length == 0) {
            return null;
        }
        return constructByPreOrderArray(preOrderArray, 0, preOrderArray.length - 1);
    }

    private static TreeNode constructByPreOrderArray(Integer[] preOrderArray, int start, int end) {
        if (start > end || preOrderArray[start] == null) {
            return null;
        }
        TreeNode head = new TreeNode(preOrderArray[start]);
        head.left = constructByPreOrderArray(preOrderArray, start + 1, start + (end - start) / 2);
        head.right = constructByPreOrderArray(preOrderArray, start + (end - start) / 2 + 1, end);
        return head;
    }
}
