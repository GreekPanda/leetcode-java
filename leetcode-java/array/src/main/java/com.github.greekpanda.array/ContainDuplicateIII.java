package com.github.greekpanda.array;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;

/**
 * Contains Duplicate III
 * 描述
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such
 * that the difference between nums[i] and nums[j] is at most t and the difference between i and
 * j is at most k .
 * 分析
 * 这一题比 "Contains Duplicate II" 有多了个条件，难度陡然就增大了。
 * 对于数组内的一个整数，如果能方便的求出大于它的最小整数和小于它的最大整数，那么我们就可以判断
 * 差值是否大于 t 。能方便的求出最大下限和最小上限，最先想到的数据结构是二叉搜索树BST，因为左孩
 * 子就是最大下限，右孩子就是最小上限。
 * 可以用一个大小为k的滑动窗口，将窗口内的元素组织成一个BST，每次向前滑动一步，添加一个新元素，
 * 同时删除一个最老的元素，如此不断向前滑动，不断更新BST。如果BST内部有两个元素差值大于 t ，则
 * 返回true，如果直到扫描完数组，BST里都没有出现差值大于k的两个数，则返回false。
 * 对于BST数据结构，可以用现成的，C++里是 multiset ，Java里是 TreeSet
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/24 22:13
 */
@Slf4j
public class ContainDuplicateIII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 19, 100, 123, 34, 56, 78, 123, 123, 11};
        boolean ret = ContainDuplicateIII.containNearByAndMostKDistance(nums, 1, 1);
        log.info(String.valueOf(ret));
    }

    public static boolean containNearByAndMostKDistance(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 0 || k < 1 || t < 0)
            throw new RuntimeException();

        final TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final Integer floor = ts.floor(x);
            final Integer ceiling = ts.ceiling(x);

            if ((floor != null && x <= floor + t) || (ceiling != null && x >= ceiling - t)) {
                return true;
            }
            ts.add(x);
            if (i >= k)
                ts.remove(nums[i - k]);
        }
        return false;
    }
}
