package com.github.greekpanda.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * 描述
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0 ?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4} .
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 分析
 * 先排序，然后左右夹逼，复杂度 O(n )。
 * 这个方法可以推广到 k-sum ，先排序，然后做 k-2 次循环，在最内层循环左右夹逼，时间复杂度是
 * O(max{n log n, n })
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 18:23
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> ret = threeSum(nums);
        System.out.println(ret);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <=3)
            throw new RuntimeException();

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        final  int target = 0;

        for(int i = 0; i < nums.length - 2; ++i) {
            if(nums[i] == nums[i + 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if(nums[i] +nums[j] +nums[k] < target ) {
                    ++j;
                    while(nums[j] == nums[j - 1] && j < k) ++j;
                } else if(nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while (nums[k] == nums[k + 1] && j < k) --k;
                } else {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while (nums[j] == nums[j - 1]) ++j;
                    while (nums[k] == nums[k + 1]) --k;
                }
            }

        }

        return lists;
    }
}
