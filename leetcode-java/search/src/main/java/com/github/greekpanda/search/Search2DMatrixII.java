package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Search a 2D Matrix II
 * 描述
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 * properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * Consider the following matrix:
 * [
 * [1, 4, 7, 11, 15],
 * [2, 5, 8, 12, 19],
 * [3, 6, 9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5 , return true .
 * Given target = 20 , return false
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/15 23:42
 */
@Slf4j
public class Search2DMatrixII {
    public static void main(String[] args) {
        final int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean ret1 = search(matrix, 5);
        boolean ret2 = search(matrix, 29);
        log.info(String.valueOf(ret1));
        log.info(String.valueOf(ret2));
    }

    public static boolean search(final int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }


        int m = 0;
        int n = matrix[0].length - 1;

        while (m < matrix.length && n >= 0) {
            final int x = matrix[m][n];
            if (target == x) {
                return true;
            } else if (x < target) {
                ++m;
            } else {
                --n;
            }
        }
        return false;
    }
}
