package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 08:51
 */
@Slf4j
public class ValidateBST {
    public static void main(String[] args) {

    }

    public static boolean isValidBTS(TreeNode root) {
        if (root == null)
            return false;

        return isValidBTS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBTS(TreeNode root, int lower, int upper) {
        if (root == null || lower > upper)
            return false;

        return root.val > lower
                && root.val < upper
                && isValidBTS(root.left, lower, root.val)
                && isValidBTS(root.right, root.val, upper);
    }
}
