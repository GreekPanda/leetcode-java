package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * 描述
 * Given n , generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example, Given n = 3 , your program should return all 5 unique BST's shown below.
 * 1 3 3 2 1
 * \ / / / \ \
 * 3 2 1 1 3 2
 * / / \ \
 * 2 1 2 3
 * 分析
 * 见前面一
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 08:43
 */
@Slf4j
public class UniqueBSTII {
    public static void main(String[] args) {

    }

    public List<TreeNode> genTree(int n) {
        if (n < 0)
            return null;

        if (n == 0)
            return new ArrayList<>();

        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();
        for (int i = start; i < end; i++) {
            List<TreeNode> leftSubs = generate(start, i - 1);
            List<TreeNode> rightSubs = generate(i + 1, end);

            for (TreeNode left : leftSubs) {
                for (TreeNode right : rightSubs) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }
}
