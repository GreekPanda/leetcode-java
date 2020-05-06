package com.github.greekpanda.array;

/**
 * Remove Duplicates from Sorted Array
 * 描述
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return
 * the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2] ,
 * Your function should return length = 2, and A is now [1,2] .
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 12:05
 */
public class RemoveDuplicate {

    public static int[] removeDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        int index = 0;
        for (int n : nums) {
            if (index < 1 || n != nums[index - 1]) {
                nums[index] = n;
                index++;
            }
        }
        System.out.println(index);
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        RemoveDuplicate.removeDuplicate(nums);
        for (int n : nums) {
            System.out.print(n + "\t");
        }
    }
}
