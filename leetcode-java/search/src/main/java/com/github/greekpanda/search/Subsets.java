package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 * 描述
 * Given a set of distinct integers, S , return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, If S = [1,2,3] , a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/17 22:39
 */
@Slf4j
public class Subsets {
    public static void main(String[] args) {
        final int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        log.info(String.valueOf(result));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsets(nums, 0, path, result);

        return result;
    }

    private static void subsets(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        subsets(nums, start + 1, path, result);
        path.add(nums[start]);
        subsets(nums, start + 1, path, result);
        path.remove(path.size() - 1);
    }
}
