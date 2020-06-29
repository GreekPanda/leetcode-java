package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * Merge Two Sorted Arrays
 * 描述
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space to hold additional elements from B. The number of
 * elements initialized in A and B are m and n respectively
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 08:12
 */
@Slf4j
public class MergeTwoSortedArray {
    public static void main(String[] args) {

    }

    public static void merge(int[] numsA, int m, int[] numsB, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;

        while (i >= 0 && j >= 0) {
            numsA[cur--] = numsA[i] >= numsB[j] ? numsA[i--] : numsA[j--];
        }

        while (j >= 0) {
            numsA[i--] = numsB[j--];
        }
    }
}
