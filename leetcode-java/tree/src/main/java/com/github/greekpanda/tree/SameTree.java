package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Same Tree
 * 描述
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same
 * value.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 08:18
 */
@Slf4j
public class SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        if (root1 == null && root2 == null)
            return true;

        return root1.val == root2.val
                && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    public static boolean isSameTree1(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        if (root1 == null && root2 == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        stack.push(root2);

        while (!stack.isEmpty()) {
            root1 = stack.pop();
            root2 = stack.pop();

            if (root1 == null || root2 == null)
                return false;
            if (root1 == null && root2 == null)
                continue;
            if (root1.val != root2.val)
                return false;

            stack.push(root1.left);
            stack.push(root2.left);

            stack.push(root1.right);
            stack.push(root2.right);
        }
        return true;
    }
}
