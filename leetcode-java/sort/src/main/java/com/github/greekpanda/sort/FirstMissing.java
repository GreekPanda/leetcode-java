package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * 桶排序
 * <p>
 * First Missing Positive
 * 描述
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, Given [1,2,0] return 3 , and [3,4,-1,1] return 2 .
 * Your algorithm should run in O(n) time and uses constant space.
 * 分析
 * 本质上是桶排序(bucket sort)，每当 A[i]!= i+1 的时候，将 A[i] 与 A[A[i]-1] 交换，直到无法交换
 * 为止，终止条件是 A[i]== A[A[i]-1] 。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/6 07:32
 */
@Slf4j
public class FirstMissing {
    public static void main(String[] args) {

        Class<?> clazz = FirstMissing.class;
        clazz.getFields();
        clazz.getDeclaredFields();
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }

        bucket_sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void bucket_sort(int[] nums) {
        final int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] < 0 || nums[i] > n || nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

    }

}
