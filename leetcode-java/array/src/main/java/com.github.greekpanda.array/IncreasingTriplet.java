package com.github.greekpanda.array;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * Increasing Triplet Subsequence
 * 描述
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * More specifically, if there exists i , j , k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j
 * < k ≤ n-1 return true else return false .
 * Your function should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5] , return true .
 * Given [5, 4, 3, 2, 1] , return false .
 * 分析
 * 扫描一遍数组，用变量 x1 保存当前最小的值，变量 x2 保存当前第二小的值。如果右面能碰到一个数大
 * 于 x2 ，说明必然存在一个递增的三元组。
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 22:45
 */
@Slf4j
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        boolean ret = increasingTripletSubsequence(nums);
        log.info(String.valueOf(ret));
        int[] nums1 = new int[]{5, 4, 3, 2, 1};
        boolean ret1 = increasingTripletSubsequence(nums1);
        log.info(String.valueOf(ret1));
    }

    public static boolean increasingTripletSubsequence(int[] nums) {
        if(nums == null || nums.length <= 0)
            throw new RuntimeException();

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for(int x : nums) {
            if(x <= i) i = x;
            else if(x <= j) j = x;
            else return true;
        }
        return false;
    }
}
