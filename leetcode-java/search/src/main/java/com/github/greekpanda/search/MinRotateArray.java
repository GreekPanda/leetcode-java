package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Find Minimum in Rotated Sorted Array
 * 描述
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 分析
 * 从左向右扫描，扫描到的第一个逆序的位置，肯定是原始数组中第一个元素，时间复杂度 O(n) 。
 * 不过本题依旧可以用二分查找，最关键的是要判断那个“断层”是在左边还是右边。
 * 若 A[mid] < A[right] ，则区间 [mid,right] 一定递增，断层一定在左边
 * 若 A[mid] > A[right] ，则区间 [left,mid] 一定递增，断层一定在右边
 * nums[mid] == nums[right] ，这种情况不可能发生，因为数组是严格单调递增的，不存在重复元素
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/15 23:49
 */
@Slf4j
public class MinRotateArray {
    public static void main(String[] args) {
        final int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int ret = search(nums);
        log.info(String.valueOf(ret));
    }

    public static int search(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            final int mid = left + (right - left) >> 1;
            if (nums[left] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];

    }
}
