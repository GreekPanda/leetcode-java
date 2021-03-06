package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Path Sum
 * 描述
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the
 * values along the path equals the given sum.
 * For example: Given the below binary tree and sum = 22 ,
 * 5
 * / \
 * 4 8
 * / / \
 * 11 13 4
 * / \ \
 * 7 2 1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22
 * <p>
 * 题目只要求返回 true 或者 false ，因此不需要记录路径。
 * 由于只需要求出一个结果，因此，当左、右任意一棵子树求到了满意结果，都可以及时return。
 * 由于题目没有说节点的数据一定是正整数，必须要走到叶子节点才能判断，因此中途没法剪枝，只能进行
 * 朴素深搜。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/22 09:01
 */
@Slf4j
public class PathSum {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

}
