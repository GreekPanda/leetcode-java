package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search in Rotated Sorted Array II
 * 描述
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 分析
 * 允许重复元素，则上一题中如果 A[left] <= A[mid] ,那么 [left,mid] 为递增序列的假设就不能成立
 * 了，比如 [1,3,1,1,1] 。
 * 既然 A[left] <= A[mid] 不能确定递增，那就把它拆分成两个条件：
 * 若 A[left] < A[mid] ，则区间 [left,mid] 一定递增
 * 若 A[left] == A[mid] 确定不了，那就 left++ ，往下看一步即可。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/14 22:25
 */
@Slf4j
public class SearchRotateArrayII {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start != end) {
            int mid = start + (end - start) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid])
                    start = mid;
                else
                    end = mid + 1;
            } else if (nums[start] > nums[mid]) {
                if (nums[mid] < target && target <= nums[end - 1])
                    start = mid + 1;
                else
                    end = mid;
            } else
                //skip duplicate one
                start++;
        }
        return -1;
    }
}
