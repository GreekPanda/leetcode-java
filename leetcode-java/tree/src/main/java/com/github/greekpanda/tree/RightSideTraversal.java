package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Right Side View
 * 描述
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you
 * can see ordered from top to bottom.
 * For example, given the following binary tree,
 * 1 <---
 * / \
 * 2 3 <---
 * \ \
 * 5 4 <---
 * You should return [1, 3, 4] .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/16 13:56
 */
@Slf4j
public class RightSideTraversal {
    public static void main(String[] args) {
        Integer[] preOrderArray = {1, 2, null, 5, 3, null, 4};
        TreeNode root = ConstructBinaryTree.constructByPreOrderArray(preOrderArray);

        List<Integer> result = rightSideTraversal(root);
        log.info(String.valueOf(result));
    }

    public static List<Integer> rightSideTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null) {
            return result;
        } else {
            cur.offer(root);
        }

        while (!cur.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                level.add(node.val);

                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }
            result.add(level.get(level.size() - 1));

            Queue<TreeNode> tmp = cur;
            cur = next;
            next = tmp;
        }
        return result;
    }
}
