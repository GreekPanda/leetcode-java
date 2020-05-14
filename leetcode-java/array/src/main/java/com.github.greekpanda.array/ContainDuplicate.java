package com.github.greekpanda.array;


import java.util.Arrays;
import java.util.HashSet;

/**
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/14 08:04
 */
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        //int[] nums = new int[]{1,1,1,2,3,4,5};
        boolean ret1 = containDuplicate1(nums);
        boolean ret2 = containDuplicate(nums);
        System.out.println("ret1 = " + ret1 +  "\t" + "ret2 = " + ret2);
    }

    public static boolean containDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i))
                return true;
            else
                hashSet.add(i);
        }
        return false;
    }

    public static boolean containDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}
