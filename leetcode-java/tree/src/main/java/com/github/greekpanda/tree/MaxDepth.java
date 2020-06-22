package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/22 09:00
 */
@Slf4j
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
