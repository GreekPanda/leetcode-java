package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Maximum Gap
 * 描述
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted
 * form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer
 * range.
 * 分析
 * 这道题最直接的解法是，先排序，得到有序数组，然后相邻元素相减，找出差最大的，时间复杂度 O(n
 * log n) 。
 * 然而本题要求 O(n) 时间，有没有 O(n) 的排序算法呢？桶排序、基数排序、计数排序。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/31 22:07
 */
@Slf4j
public class MaxGap {
    public static void main(String[] args) {

    }

    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            throw new RuntimeException();
        }

        bucketSort(nums);
        radixSort(nums);
        countingSort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for(int i = 1 ; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i -  1]);
        }
        return maxDiff;

    }

    private static void bucketSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        final int bucketSize = (max - min) / nums.length + 1;
        final int bucketCount = (max - min) / bucketSize + 1;
        final ArrayList<Integer> buckets[] = new ArrayList[bucketCount];

        for(int i = 0; i < nums.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for(int x : nums) {
            final  int index = (x - min) / bucketSize;
            buckets[index].add(x);
        }

        for(final ArrayList<Integer> list : buckets) {
            Collections.sort(list);
        }

        int i = 0;
        for(final ArrayList<Integer> list : buckets) {
            for(int x : list) {
                nums[i++] = x;
            }
        }

    }

    private static void radixSort(int[] nums) {

    }

    private static void countingSort(int[] nums) {

    }
}
