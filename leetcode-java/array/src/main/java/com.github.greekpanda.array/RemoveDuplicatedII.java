package com.github.greekpanda.array;

/**
 * Remove Duplicates from Sorted Array II
 * 描述
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, given sorted array A = [1,1,1,2,2,3] , your function should return length = 5 , and A is
 * now [1,1,2,2,3]
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 12:42
 */
public class RemoveDuplicatedII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3};
        int[] ret = RemoveDuplicatedII.removeDuplicate(nums);
        for (int n : ret) {
            System.out.print(n + "\t");
        }

    }

    public static int[] removeDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return nums;
    }
}
