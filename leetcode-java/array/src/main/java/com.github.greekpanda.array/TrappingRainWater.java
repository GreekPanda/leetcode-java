package com.github.greekpanda.array;

/**
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 23:35
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = trappingRainWater(nums);
        System.out.println(sum);
    }

    public static int trappingRainWater(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException();

        final int n = nums.length;

        int[] rightPeek = new int[n];
        int[] leftPeek = new int[n];

        for (int i = 1; i < n; i++) {
            leftPeek[i] = Math.max(leftPeek[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightPeek[i] = Math.max(rightPeek[i + 1], nums[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int height = Math.min(leftPeek[i], rightPeek[i]);
            if (height > nums[i])
                sum += height - nums[i];
        }
        return sum;
    }
}
