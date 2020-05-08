package com.github.greekpanda.array;

import java.util.Arrays;

/**
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/8 08:35
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {0, 7, 9}};
        setMatrixZero(matrix);
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + "\t");

    }

    public static int[][] setMatrixZero(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length < 0)
            throw new RuntimeException();

        final int m = matrix.length;
        final int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = row[j] = true;
                }
            }
        for (int i = 0; i < m; ++i) {
            if (row[i])
                Arrays.fill(matrix[i], 0);
        }

        for (int j = 0; j < n; ++j) {
            if (col[j]) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
