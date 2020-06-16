package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 * 描述
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3} ,
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1] .
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 13:16
 */
@Slf4j
public class postOrderTraversal {
    public static void main(String[] args) {
//Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
        Integer[] preOrderArray = {1, 2, 4, null, 7, null, null, null, 3, 5, null, null, 6, 8, null};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        List<Integer> result = postOrderTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode q = null;

        do {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            q = null;
            while (!stack.isEmpty()) {
                p = stack.pop();

                if (p.right == q) {
                    result.add(p.val);
                    q = p;
                } else {
                    stack.push(p);
                    p = p.right;
                    break;
                }
            }
        } while (!stack.isEmpty());

        return result;
    }
}
