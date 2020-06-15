package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example: Given binary tree {1,#,2,3} ,
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3] .
 * Note: Recursive solution is trivial, could you do it iteratively
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/15 08:52
 */
@Slf4j
public class PreOrderTraversal {
    public static void main(String[] args) {
        //Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
        Integer[] preOrderArray = {1, 2, 4, null, 7, null, null, null, 3, 5, null, null, 6, 8, null};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        List<Integer> result = preOrderTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null)
            throw new RuntimeException();

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            final TreeNode treeNode = stack.pop();
            result.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return result;
    }
}
