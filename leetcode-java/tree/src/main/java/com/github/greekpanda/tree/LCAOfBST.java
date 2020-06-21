package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * LCA of BST
 * 描述
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * _______6______
 * / \
 * ___2__ ___8__
 * / \ / \
 * 1 _4 7 9
 * / \
 * 3 5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes
 * 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 分析
 * 根据二叉搜索树的性质，两个子节点 p , q 和根节点 root 的关系，有以下四种情况：
 * 1. 两个子节点都在树的左子树上
 * 2. 两个子节点都在树的右子树上
 * 3. 一个子节点在左子树，一个子节点在右子树
 * 4. 一个子节点的值和根节点的值相等
 * 以题目中的树为例，节点1和节点4为情况1，节点7和节点9为情况2，节点1和节点7为情况3，节点2和4为
 * 情况4。 若为情况3或4，当前节点即为最近公共祖先，若为情况1或2，则还需递归到左或右子树上，继续
 * 这个过程。
 * 该算法的时间复杂度为 O(h) ， h 为树的高度
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 09:10
 */
@Slf4j
public class LCAOfBST {
    public static void main(String[] args) {

    }

    //recursive
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    //Iterator
    private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;


        while (root != null) {
            if (Math.max(p.val, q.val) < root.val) {
                root = root.left;
            } else if (Math.min(p.val, q.val) > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
