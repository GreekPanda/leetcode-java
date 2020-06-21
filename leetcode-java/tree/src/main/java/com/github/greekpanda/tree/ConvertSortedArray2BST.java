package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Convert Sorted Array to Binary Search Tree
 * 描述
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 分析
 * 二分法
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 08:55
 */
@Slf4j
public class ConvertSortedArray2BST {
    public static void main(String[] args) {

    }

    public static TreeNode sortedArray2BST(int[] nums) {
        if (nums == null || nums.length <= 0)
            return null;

        return sortedArray2BST(nums, 0, nums.length);
    }

    private static TreeNode sortedArray2BST(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 0 || start > end)
            return null;

        int len = end - start;
        int mid = start + end >> 1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArray2BST(nums, start, mid);
        root.right = sortedArray2BST(nums, mid, end);

        return root;

    }

}
