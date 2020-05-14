package com.github.greekpanda.array;


import java.util.Arrays;
import java.util.HashSet;

/**
 * Contains Duplicate
 * 描述
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any
 * value appears at least twice in the array, and it should return false if every element is distinct.
 * 分析
 * 方法1， 用一个 HashSet, 不断往里面塞元素，如果发现有重复，说明存在重复。时间复杂度 O(n) ，空间
 * 复杂度 O(n) 。
 * 方法2， 排序，然后从头到尾扫描，如果发现相邻两个元素相等，则存在重复。时间复杂度 O(nlogn) ，
 * 空间复杂度 O(1) 。
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/14 08:04
 */
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        //int[] nums = new int[]{1,1,1,2,3,4,5};
        boolean ret1 = containDuplicate1(nums);
        boolean ret2 = containDuplicate(nums);
        System.out.println("ret1 = " + ret1 +  "\t" + "ret2 = " + ret2);
    }

    public static boolean containDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i))
                return true;
            else
                hashSet.add(i);
        }
        return false;
    }

    public static boolean containDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}
