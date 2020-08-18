package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations
 * 描述
 * Given a collection of numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2] , and [3,2,1] .
 * next_permutation()
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/18 22:18
 */
@Slf4j
public class Permutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ret = permutation(nums);
        log.info(String.valueOf(ret));
    }

    public static List<List<Integer>> permutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        do {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            result.add(list);
        } while (nextPermutation(nums, 0, nums.length));

        return result;
    }

    private static boolean nextPermutation(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return false;
        }

        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) {
            --p;
        }

        if (p == -1) {
            reverse(nums, start, end);
            return false;
        }

        int c = end - 1;
        while (nums[c] > 0 && nums[c] <= nums[p]) {
            --c;
        }

        swap(nums, p, c);

        reverse(nums, p + 1, end);

        return true;
    }


    private static void swap(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return;
        }

        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    private static void reverse(int[] nums, int start, int end) {
        if (nums == null || start > end) {
            return;
        }

        --end;

        while (start < end) {
            swap(nums, start++, end--);
        }

    }
}
