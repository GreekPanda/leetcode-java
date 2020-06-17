package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Binary Search Tree Iterator
 * 描述
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of
 * a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is
 * the height of the tree.
 * 分析
 * 考察非递归的中序遍历。这道题本质上是写一个二叉树的中序遍历的迭代器。内部设置一个栈，初始化的
 * 时候，存储从根节点到最左叶子节点的路径。在遍历的过程中，每次从栈中弹出一个元素，作为当前的返
 * 回结果，同时探测一下当前节点是否存在右孩子，如果有，则进入右孩子，并把从该右孩子到最左叶子节
 * 点的所有节点入栈。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/17 08:25
 */
@Slf4j
public class SearchIterator {
    private static Stack<TreeNode> stack;


    public static void main(String[] args) {

    }

    SearchIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static boolean hasNext() {
        return !stack.isEmpty();
    }

    public static int next() {
        final TreeNode treeNode = stack.pop();
        if (treeNode.right != null) {
            TreeNode p = treeNode.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return treeNode.val;
    }

}
