package com.github.greekpanda.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * 描述
 * Given an array of integers and an integer k , find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k .
 * 分析
 * 维护一个HashMap, key为整数，value为下标，将数组中的元素不断添加进这个HashMap, 碰到重复时，计
 * 算二者的下标距离，如果距离小于或等于k，则返回true, 如果直到数组扫描完，距离都大于k，则返回
 * false。
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/14 08:11
 */
public class ContainDuplicateII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,1,6,7};
        int k = 3;
        boolean ret = containDuplicate(nums, k);
        System.out.println(ret);
    }

    public static boolean containDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k > nums.length || k < 0)
            throw new RuntimeException();

        final Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i])) {
                final  int preIndex = map.get(nums[i]);
                final int gap = i - preIndex;
                min = Math.min(gap, min);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }
}
