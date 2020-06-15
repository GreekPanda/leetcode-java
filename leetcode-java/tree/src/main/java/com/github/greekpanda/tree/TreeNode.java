package com.github.greekpanda.tree;

/**
 *  二叉树的遍历
 * 树的遍历有两类：深度优先遍历和宽度优先遍历。深度优先遍历又可分为两种：先根（ 次序） 遍历和后根
 * （ 次序） 遍历。
 * 树的先根遍历是：先访问树的根结点，然后依次先根遍历根的各棵子树。树的先跟遍历的结果与对应二叉
 * 树（ 孩子兄弟表示法） 的先序遍历的结果相同。
 * 树的后根遍历是：先依次后根遍历树根的各棵子树，然后访问根结点。树的后跟遍历的结果与对应二叉树
 * 的中序遍历的结果相同。
 * 二叉树的先根遍历有：先序遍历(root->left->right)，root->right->left；后根遍历有：后序遍历(left->right-
 * >root)，right->left->root；二叉树还有个一般的树没有的遍历次序，中序遍历(left->root->right)。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/11 11:02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {

    }

    TreeNode(int x) {
        this.val = x;
    }
}
