package com.github.greekpanda.array;

/**
 * Move Zeroes
 * 描述
 * Given an array nums , write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12] , after calling your function, nums should be [1, 3,
 * 12, 0, 0] .
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 22:26
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 4, 0, 6, 0, 7, 0};
        moveZero(nums);
        for(int n : nums) {
            System.out.print(n + "\t");
        }
    }

    public static int[] moveZero(int[] nums) {
        if (nums == null || nums.length <= 1)
            throw new RuntimeException();

        int index = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }
        for(int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
        System.out.println(index);
        return nums;
    }
}
