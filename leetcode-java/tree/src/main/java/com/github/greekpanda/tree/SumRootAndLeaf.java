package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Sum Root to Leaf Numbers
 * 描述
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123 .
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2 3
 * The root-to-leaf path 1->2 represents the number 12 . The root-to-leaf path 1->3 represents the
 * number 13 .
 * Return the sum = 12 + 13 = 25
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:45
 */
@Slf4j
public class SumRootAndLeaf {
    public static void main(String[] args) {

    }

    public static int sum(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        return dfs(root.left, sum * 10 + root.val)
                + dfs(root.right, sum * 10 + root.val);
    }
}
