package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Range Sum Query - Mutable
 * 描述
 * Given an integer array nums , find the sum of the elements between indices i and j ( i ≤ j ),
 * inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val .
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * 1. The array is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRange function is distributed evenly.
 * 分析
 * 由于需要求任意段的和，且会随机修改元素，用线段树(Segment Tree)再合适不过了。
 * 另外一个数据结构，树状数组(Binary Indexed Tree)，也适合解这道题
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:55
 */
@Slf4j
public class RangeSum {
    public static void main(String[] args) {

    }


    //TODO:
}
