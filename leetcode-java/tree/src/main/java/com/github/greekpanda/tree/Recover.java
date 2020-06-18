package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 *Recover Binary Search Tree
 * 描述
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space
 * solution?
 * 分析
 * O(logn) 空间的解法是，中序递归遍历，用两个指针存放在遍历过程中碰到的两处逆向的位置。
 * 本题要求 O(1) 空间，只能用Morris中序遍历。
 * 中序遍历，递归方式
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/17 08:42
 */
@Slf4j
public class Recover {

    static TreeNode  p1 = null;
    static TreeNode p2 = null;
    static TreeNode prev = null;


    public static void main(String[] args) {

    }

    //O(1), morris inorder traversal
    public static void recoverTree(TreeNode root) {
        if(root == null)
            return;

        inOrder(root);

        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
    }

    private static void inOrder(TreeNode root) {
        if(root == null)
            return;

        if(root.left != null)
            inOrder(root.left);

        if(prev != null && prev.val > root.val) {
            if(p1 != null) {
                p1 = prev;
            }
            p2 = root;
            prev = root;
        }

        if(root.right != null)
            inOrder(root.right);
    }
}
