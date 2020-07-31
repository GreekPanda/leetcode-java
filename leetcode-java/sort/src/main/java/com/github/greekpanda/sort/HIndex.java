package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * H-Index
 * 描述
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to
 * compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have
 * at least h citations each, and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5] , which means the researcher has 5 papers in total
 * and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3
 * papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index
 * is 3.
 * Note: If there are several possible values for h , the maximum one is taken as the h-index.
 * 分析
 * H-Index的含义是，如果一个人发表的所有论文中，有 h 篇论文分别被引用了至少 h 次，那么他的HIndex就是 h 。
 * 思路一：先从大到小排序，然后从前往后扫描，如果当前文章数（ 即当前下标+1） 等于值本身，则返回当
 * 前文章数作为 h-index；如果当前文章数大于值本身，则返回当前文章数-1作为H-Index, 因为当前文章的引
 * 用数小于当前文章数，不能算在内。时间复杂度O(nlog n，空间复杂度O(1)。
 * 思路二：跟思路一类似，不过排序算法换成了计数排序。有一个小技巧，因为H-Index最大不可能超过论文
 * 综述，所以我们只需要开一个长度为 n+1 的数组，如果某篇论文的引用数超过了 n ，就将其当做 n
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/31 22:01
 */
@Slf4j
public class HIndex {
    public static void main(String[] args) {

    }

    public static int hIndex(int[] nums) {
        if(nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        final int n = nums.length;
        final int[] histogram = new int[n + 1];

        for(int x : nums) {
            ++histogram[x > n ? n : x];
        }

        int sum = 0;
        for(int i = n; i > 0 ; i--) {
            sum += histogram[i];
            if(sum >= i) {
                return i;
            }
        }
        return  0;
    }
}
