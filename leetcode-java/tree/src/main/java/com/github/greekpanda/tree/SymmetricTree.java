package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 1
 * / \
 * 2 2
 * / \ / \
 * 3 4 4 3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2 2
 * \ \
 * 3 3
 * Note: Bonus points if you could solve it both recursively and iteratively.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 08:25
 */
@Slf4j
public class SymmetricTree {
    public static void main(String[] args) {
        Integer[] preOrderArray = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        boolean ret = isSymmetricTree(root);
        log.info(String.valueOf(ret));
        boolean ret1 = isSymmetricTree1(root);
        log.info(String.valueOf(ret1));
    }

    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetricTree(root.left, root.right);
    }

    private static boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return p.val == q.val
                && isSymmetricTree(p.left, q.left)
                && isSymmetricTree(p.right, q.right);
    }

    private static boolean isSymmetricTree1(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();

            if (p == null || q == null)
                return false;
            if (p == null && q == null)
                return true;
            if (p.val != q.val)
                return false;

            stack.push(p.left);
            stack.push(q.left);

            stack.push(p.right);
            stack.push(q.right);
        }
        return true;
    }
}
