package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 * 描述
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by
 * level).
 * For example: Given binary tree {3,9,20,#,#,15,7} ,
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 13:28
 */
@Slf4j
public class LevelOrderTraversal {
    public static void main(String[] args) {
        //Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
        Integer[] preOrderArray = {1, 2, 4, null, 7, null, null, null, 3, 5, null, null, 6, 8, null};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        List<List<Integer>> result = levelOrderTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if(root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        return result;
    }

    private static void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)
            return;

        if(level > result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(root.val);
        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }
}
