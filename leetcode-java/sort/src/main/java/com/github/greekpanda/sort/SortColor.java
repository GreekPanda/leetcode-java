package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * Sort Colors
 * 描述
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * 分析
 * 由于0, 1, 2 非常紧凑，首先想到计数排序(counting sort)，但需要扫描两遍，不符合题目要求。
 * 由于只有三种颜色，可以设置两个index，一个是red的index，一个是blue的index，两边往中间走。时间复
 * 杂度 O(n) ，空间复杂度 O(1) 。
 * 第3种思路，利用快速排序里 partition 的思想，第一次将数组按0分割，第二次按1分割，排序完毕，可以推
 * 广到 n 种颜色，每种颜色有重复元素的情
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/2 23:03
 */
@Slf4j
public class SortColor {
    public static void main(String[] args) {

    }

    public static void setColors(int[] nums) {
        if (nums == null)
            return;

        int[] counts = new int[3];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        for (int i = 0, index = 0; i < 3; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
