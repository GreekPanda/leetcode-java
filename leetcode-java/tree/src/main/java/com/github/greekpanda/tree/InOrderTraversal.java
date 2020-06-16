package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3} ,
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2] .
 * Note: Recursive solution is trivial, could you do it iteratively
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 13:12
 */
@Slf4j
public class InOrderTraversal {
    public static void main(String[] args) {
//Integer[] preOrderArray = new Integer[]{1, null, 2, 3, 4, null, 5, 6};
        Integer[] preOrderArray = {1, 2, 4, null, 7, null, null, null, 3, 5, null, null, 6, 8, null};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);
        List<Integer> result = inOrderTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        if(root == null)
            return null;

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
               p =  stack.pop();
               result.add(p.val);
               p = p.right;
            }
        }
        return result;
    }
}
