package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * H-Index II
 * 描述
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your
 * algorithm?
 * 分析
 * 设数组长度为 n ，那么 n-i 就是引用次数大于等于 nums[i] 的文章数。如果 nums[i]<n-i ，说
 * 明 i 是有效的H-Index, 如果一个数是H-Index，那么最大的H-Index一定在它后面（ 因为是升序的） ，根据
 * 这点就可以进行二分搜索了。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/17 22:34
 */
@Slf4j
public class HIndexII {
    public static void main(String[] args) {

    }
    public static int hIndex(int[] nums) {
        if(nums == null || nums.length <=0) {
            throw new RuntimeException();
        }

        final int len = nums.length;
        int start = 0;
        int end = nums.length;

        while(start != end) {
            final int mid = start + (end - start) >> 1;
            if(nums[mid] < len - mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return len - start;
    }
}
