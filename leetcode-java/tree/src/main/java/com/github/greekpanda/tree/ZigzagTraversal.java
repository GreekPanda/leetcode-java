package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Zigzag Level Order Traversal
 * 描述
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7} ,
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ] 分
 * 析
 * 广度优先遍历，用一个bool记录是从左到右还是从右到左，每一层结束就翻转一下
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/17 08:29
 */
@Slf4j
public class ZigzagTraversal {
    public static void main(String[] args) {

        //Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
        Integer[] preOrderArray = {3, 9, null, null, 20, 15, 7};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        List<List<Integer>> result = zigzagLevelTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<List<Integer>> zigzagLevelTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result, true);
        return result;
    }

    private static void traverse(TreeNode root, int level, List<List<Integer>> result, boolean left2Right) {
        if (root == null)
            return;

        if (level > result.size())
            result.add(new ArrayList<>());

        if (left2Right) {
            result.get(level - 1).add(root.val);
        } else {
            result.get(level - 1).add(0, root.val);
        }

        traverse(root.left, level + 1, result, !left2Right);
        traverse(root.right, level + 1, result, !left2Right);

    }


}
