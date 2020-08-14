package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search in Rotated Sorted Array
 * 描述
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * You are given a target value to search. If found in the array return its index, otherwise return -1 .
 * You may assume no duplicate exists in the array.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/14 21:58
 */
@Slf4j
public class SearchRotateArray {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length;
        while (start != end) {
            final int mid = start + (end - start) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end - 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
