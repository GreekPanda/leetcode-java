package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search a 2D Matrix
 * 描述
 * Write an efficient algorithm that searches for a value in an m × n matrix. This matrix has the following
 * properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example, Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3 , return true
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/15 23:34
 */
@Slf4j
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        boolean ret = search(matrix, 3);
        log.info(String.valueOf(ret));
    }

    public static boolean search(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length <= 0) {
            return false;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;

        int start = 0;
        int end = m * n;

        while (start != end) {
            final int mid = start + (end - start) >> 1;
            int value = matrix[mid / n][mid % n];

            if (value == target) {
                return true;
            } else if (value < target) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return false;
    }
}
