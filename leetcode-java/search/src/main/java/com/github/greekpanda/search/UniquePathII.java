package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Unique Paths II
 * 描述
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3 × 3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 14:36
 */
@Slf4j
public class UniquePathII {
    private static int[][] f;

    public static void main(String[] args) {

    }

    public static int uniquePath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return 0;
        }

        f = new int[m][n];
        f[0][0] = grid[0][0] != 0 ? 0 : 1;
        return dfs(grid, m - 1, n - 1);
    }

    private static int dfs(int[][] grid, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (grid[m][n] != 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return f[0][0];
        }

        if (f[m][n] > 0) {
            return f[m][n];
        } else {
            return f[m][n] = dfs(grid, m - 1, n) + dfs(grid, m, n - 1);
        }
    }
}
