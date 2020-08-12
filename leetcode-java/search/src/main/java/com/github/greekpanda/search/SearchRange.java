package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search for a Range
 * 描述
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n) .
 * If the target is not found in the array, return [-1, -1] .
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4] .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/13 07:16
 */
@Slf4j
public class SearchRange {
    public static void main(String[] args) {
        final int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        final int target = 0;
        int[] ret = searchRange(nums, target);
        for(int i : ret) {
            log.info(String.valueOf(i));
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, 0, nums.length, target);
        int upper = upperBound(nums, 0, nums.length, target);

        if (lower == nums.length && nums[lower] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{lower, upper - 1};
        }
    }

    private static int lowerBound(int[] nums, int start, int end, int target) {
        while (start != end) {
            int mid = start + (end - start) >> 1;
            if (target > nums[mid]) {
                start = ++mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int upperBound(int[] nums, int start, int end, int target) {
        while (start != end) {
            int mid = start + (end - start) >> 1;
            if (target >= nums[mid]) {
                start = ++mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
