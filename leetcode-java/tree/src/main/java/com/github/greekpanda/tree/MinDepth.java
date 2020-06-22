package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Minimum Depth of Binary Tree
 * 描述
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/22 08:55
 */
@Slf4j
public class MinDepth {
    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        return minDepth(root, false);
    }

    private static int minDepth(TreeNode root, boolean hasSibling) {
        if (root == null) {
            return hasSibling ? Integer.MIN_VALUE : 0;
        }

        return 1 + Math.min(minDepth(root.left, root.right != null)
                , minDepth(root.left, root.left != null));
    }
}
