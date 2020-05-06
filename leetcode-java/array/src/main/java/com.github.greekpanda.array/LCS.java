package com.github.greekpanda.array;

import java.util.HashSet;

/**
 * Longest Consecutive Sequence
 * 描述
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2] , The longest consecutive elements sequence is [1, 2,
 * 3, 4] . Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 分析
 * 如果允许O(nlog n)的复杂度，那么可以先排序，可是本题要求 O(n) 。
 * 由于序列里的元素是无序的，又要求 O(n) ，首先要想到用哈希表。
 * 用一个哈希表存储所有出现过的元素，对每个元素，以该元素为中心，往左右扩张，直到不连续为止，记
 * 录下最长的长度
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 16:29
 */
public class LCS {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,100,120,5,9, 6, 8 ,7};
        HashSet<Integer> integerHashSet = lcs(nums);
        System.out.println(integerHashSet + " and length is: " + integerHashSet.size());
    }

    public static HashSet<Integer> lcs(int[] nums) {
        if(nums == null || nums.length <= 0)
            throw new RuntimeException();

        HashSet<Integer> ret = new HashSet<>();
        HashSet<Integer> integerHashSet = new HashSet<>();
        for(int n : nums){
            integerHashSet.add(n);
        }

        int longest = 0;
        for(int i : nums) {
            int length = 1;
            for(int j = i - 1; integerHashSet.contains(j); --j) {
                ret.add(j);
                integerHashSet.remove(j);
                ++length;
            }
            for(int j = i + 1; integerHashSet.contains(j); ++j) {
                ret.add(j);
                integerHashSet.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return ret;
    }
}
