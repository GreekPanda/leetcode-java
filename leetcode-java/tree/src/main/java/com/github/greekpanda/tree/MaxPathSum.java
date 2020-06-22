package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Binary Tree Maximum Path Sum
 * 描述
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree. For example: Given the below binary tree,
 * 1
 * / \
 * 2 3
 * Return 6 .
 * 分析
 * 这题很难，路径可以从任意节点开始，到任意节点结束。
 * 可以利用“最大连续子序列和”问题的思路，见这节Maximum Subarray。如果说Array只有一个方向的话，那
 * 么Binary Tree其实只是左、右两个方向而已，我们需要比较两个方向上的值。
 * 不过，Array可以从头到尾遍历，那么Binary Tree怎么办呢，我们可以采用Binary Tree最常用的dfs来进行
 * 遍历。先算出左右子树的结果L和R，如果L大于0，那么对后续结果是有利的，我们加上L，如果R大于0，
 * 对后续结果也是有利的，继续加上R
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/22 09:14
 */
@Slf4j
public class MaxPathSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public static int maxPathSum(TreeNode root) {
        if (root == null)
            return maxSum;

        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode root) {
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;

        if (left > 0) {
            sum += left;
        }

        if (right > 0) {
            sum += right;
        }

        maxSum = Math.max(sum, maxSum);

        return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;


    }

}
