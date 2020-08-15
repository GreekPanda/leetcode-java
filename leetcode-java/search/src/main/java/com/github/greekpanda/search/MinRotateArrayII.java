package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Find Minimum in Rotated Sorted Array
 * 描述
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * Find the minimum element.
 * duplicate exists in the array.
 * 同 Find Minimum in Rotated Sorted Array 类似，要判断“断层”在左边还是右边。
 * 若 A[mid] < A[right] ，则区间 [mid,right] 一定递增，断层一定在左边
 * 若 A[mid] > A[right] ，则区间 [left,mid] 一定递增，断层一定在右边
 * 若 A[mid] == A[right] 确定不了，这个时候，断层既可能在左边，也可能在右边，所以我们不能扔
 * 掉一半，不过这时，我们可以 --right 扔掉一个
 * 本题还有另一种思路，
 * 若 A[left] < A[mid] ，则区间 [left,mid] 一定递增，断层一定在右边
 * 若 A[left] > A[mid] ，则区间 [mid,right] 一定递增，断层一定在左边
 * 若 A[left] == A[mid] 确定不了，这个时候，断层既可能在左边，也可能在右边，所以我们不能扔
 * 掉一半，不过这时，我们可以 ++left 扔掉一
 * 注意，第三种情况，我们认为可以 ++left 扔掉一个，这个做法是不对的，因为数组被分成两段后，两段
 * 分别是递增的， left 这个元素有可能是全局最小值，不能贸然扔掉。而在前一种思路中， end 可以扔
 * 掉，因为 end 在右边，它的左边必然有小于或等于它的元素，所以可以放心 --end 。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/15 23:49
 */
@Slf4j
public class MinRotateArrayII {
    public static void main(String[] args) {
        final int[] nums = new int[]{4, 5, 6, 7, 7, 0, 0, 1, 1, 1, 2, 2, 2};
        int ret = search(nums);
        log.info(String.valueOf(ret));
    }

    public static int search(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            final int mid = left + (right - left) >> 1;
            if (nums[left] < nums[right]) {
                right = mid;
            } else if (nums[left] > nums[right]) {
                left = mid + 1;
            } else {
                --right;
            }
        }

        return nums[left];

    }
}
