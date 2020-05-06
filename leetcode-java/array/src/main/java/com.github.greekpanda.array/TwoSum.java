package com.github.greekpanda.array;

import java.util.HashMap;

/**
 * Two Sum
 * 描述
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where
 * index1 must be less than index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 分析
 * 方法1：暴力，复杂度O(n )，会超时
 * 方法2：hash。用一个哈希表，存储每个数对应的下标，复杂度 O(n) .
 * 方法3：先排序，然后左右夹逼，排序O(nlog n)，左右夹逼 O(n) ，最终O(nlog n)。但是注意，这题需要
 * 返回的是下标，而不是数字本身，因此这个方法行不通
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 16:48
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6};
        int target = 9;
        int[] ret = twoSum(nums, target);
        for (int i = 0; i < ret.length; ++i) {
            System.out.print(ret[i] + "\t" + nums[ret[i]  - 1] + "--");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        //int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            final Integer v = hashMap.get(target - nums[i]);
            if (v != null && v > i) {
                return new int[]{v + 1, i + 1};
            }
        }
        return null;
    }
}
