package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Populating Next Right Pointers in Each Node II
 * 描述
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note: You may only use constant extra space.
 * For example, Given the following binary tree,
 * 1
 * / \
 * 2 3
 * / \ \
 * 4 5 7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * / \
 * 2 -> 3 -> NULL
 * / \ \
 * 4-> 5 -> 7 -> NULL
 * 分析
 * 要处理一个节点，可能需要最右边的兄弟节点，首先想到用广搜。但广搜不是常数空间的，本题要求常数
 * 空间。
 * 注意，这题的代码原封不动，也可以解决 Populating Next Right Pointers in Each Node
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/18 08:42
 */
@Slf4j
public class NextPointer2Right {
    public static void main(String[] args) {

    }

    public static void nextPointer2Right(TreeNode root) {
        if(root == null)
            return;

        //TODO:
    }

}
