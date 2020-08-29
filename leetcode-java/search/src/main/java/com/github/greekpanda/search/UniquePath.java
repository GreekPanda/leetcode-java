package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Unique Paths
 * 描述
 * A robot is located at the top-left corner of a m × n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to
 * reach the bottomright corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 14:22
 */
@Slf4j
public class UniquePath {
    public static void main(String[] args) {

    }

    public static int uniquePath(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        return uniquePath(m - 1, n) + uniquePath(m, n - 1);
    }
}
