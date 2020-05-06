package com.github.greekpanda.array;

/**
 * Next Permutation
 * 描述
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in
 * ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the
 * right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 22:32
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        for (int n : nums) {
            System.out.print(n + "\t");
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        nextPermutation(nums, 0, nums.length);
    }

    private static void nextPermutation(int[] nums, int start, int end) {
        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) --p;
        if (p == -1) {
            reverse(nums, start, end);
            return;
        }
        int c = end - 1;
        while (c > 0 && nums[c] <= nums[p]) --c;
        swap(nums, p, c);
        reverse(nums, p + 1, end);
        return;
    }

    private static void reverse(int[] nums, int start, int end) {
        end--;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }


}
