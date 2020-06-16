package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary Tree Level Order Traversal II
 * 描述
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 * For example: Given binary tree {3,9,20,#,#,15,7} ,
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 * [3],
 * ]
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 13:46
 */
@Slf4j
public class LevelOrderTraversalII {
    public static void main(String[] args) {
//Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
//        Integer[] preOrderArray = {1, 2, 4, null, 7, null, null, null, 3, 5, null, null, 6, 8, null};
        Integer[] preOrderArray = {3, 9, null, null, 20, 15, 7};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);

        List<List<Integer>> result = levelOrderTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        Collections.reverse(result);
        return result;
    }

    private static void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;

        if (level > result.size())
            result.add(new ArrayList<>());

        result.get(level - 1).add(root.val);
        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }
}
