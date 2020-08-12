package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search Insert Position
 * 描述
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/13 07:31
 */
@Slf4j
public class SearchInsertPos {
    public static void main(String[] args) {
        final int[] nums = new int[]{1, 3, 5, 6};
        final int target = 5;
        int ret = searchInsert(nums, target);
        log.info(String.valueOf(ret));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        return lowerBound(nums, 0, nums.length, target);
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
}
