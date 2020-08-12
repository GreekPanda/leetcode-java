package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Largest Number
 * 描述
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9] , the largest formed number is 9534330 .
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 分析
 * 这题可以先把每个整数变成字符串，得到一个字符串数组，然后把这个数组按特定规则排个序，顺序输出
 * 即可。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/13 07:05
 */
@Slf4j
public class LargestNumber {
    public static void main(String[] args) {
        final int[] nums = new int[]{3, 30, 34, 5, 9};
        String ret = largestNumber(nums);
        log.info(ret);

    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        final String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (String s1, String s2) -> {
            String left = s1 + s2;
            String right = s2 + s1;
            return -left.compareTo(right);
        });

        StringBuilder sb = new StringBuilder();
        for (final String s1 : s) {
            sb.append(s1);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
