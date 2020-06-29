package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * LCA of Binary Tree
 * 描述
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
 * nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to
 * be a descendant of itself).”
 * _______3______
 * / \
 * ___5__ ___1__
 * / \ / \
 * 6 _2 0 8
 * / \
 * 7 4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes
 * 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * 分析
 * 用自底向上(bottom-up)的思路，先看看是否能在 root 的左子树中找到 p 或 q ，再看看能否在右子树中
 * 找到，
 * 如果两边都能找到，说明当前节点就是最近公共祖先
 * 如果左边没找到，则说明 p 和 q 都在右子树
 * 如果右边没找到，则说明 p 和 q 都在左子树
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:50
 */
@Slf4j
public class LCAOfBT {
    public static void main(String[] args) {

    }


    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return root;

        final TreeNode left = lca(root.left, p, q);
        final TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

}
