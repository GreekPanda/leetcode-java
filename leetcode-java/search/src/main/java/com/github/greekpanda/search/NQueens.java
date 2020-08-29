package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 14:53
 */
@Slf4j
public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        List<List<String>> result = nQueens(n);
        log.info(String.valueOf(result));
    }

    public static List<List<String>> nQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] chess = new int[n];
        dfs(chess, 0, result);
        return result;
    }

    private static void dfs(int[] chess, int row, List<List<String>> result) {
        final int n = chess.length;
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                char[] c = new char[n];
                Arrays.fill(c, '.');
                for (int j = 0; j < n; ++j) {
                    if (j == chess[i]) {
                        c[i] = 'Q';
                    }
                }
                sol.add(new String(c));
            }
            result.add(sol);
            return;
        }

        for (int k = 0; k < n; ++k) {
            final boolean ok = isValid(chess, row, k);
            if (!ok) {
                continue;
            }
            chess[row] = k;
            dfs(chess, row + 1, result);
        }
    }

    private static boolean isValid(int[] chess, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (chess[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(chess[i] - col)) {
                return false;
            }
        }
        return true;
    }

}
