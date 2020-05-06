package com.github.greekpanda.array;

/**
 *
 * Remove Element
 * 描述
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 22:20
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,2,3,4,5,6};
        removeElement(nums, 2);
        for(int n : nums)
            System.out.print(n + "\t");

    }

    public static int[] removeElement(int[] nums, int target) {
        if(nums == null || nums.length <= 1)
            throw  new RuntimeException();

        int index = 0;
        for(int n : nums) {
            if(n != nums[index]) {
                nums[index++] = n;
            }
        }
        System.out.println(index);
        return nums;
    }
}
