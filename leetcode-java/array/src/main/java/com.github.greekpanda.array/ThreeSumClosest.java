package com.github.greekpanda.array;

import java.util.Arrays;

/**
 * 3Sum Closest
 * 描述
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have exactly
 * one solution.
 * For example, given array S = {-1 2 1 -4} , and target = 1 .
 * The sum that is closest to the target is 2. ( -1 + 2 + 1 = 2 ).
 * 分析
 * 先排序，然后左右夹逼，复杂度 O(n )。
 *
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 19:06
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 2, 1 ,4};
        int target = 1;

        int ret = threeSumClosest(nums, 1);
        System.out.println(ret);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 3)
            throw new RuntimeException();

        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                final  int sum = nums[i] + nums[j] + nums[k];
                final  int gap = Math.abs(sum - target);
                while(gap < minGap) {
                    result = sum;
                    minGap =  gap;
                }

                if(sum < target)
                    ++j;
                else
                    --k;
            }
        }
        return result;
    }
}
