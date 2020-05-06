package com.github.greekpanda.array;

/**
 * Rotate Image
 * 描述
 * You are given an n × n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 * 分析
 * 首先想到，纯模拟，从外到内一圈一圈的转，但这个方法太慢。
 * 如下图，首先沿着副对角线翻转一次，然后沿着水平中线翻转一次
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/7 06:51
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{3,4}};
        int[][] ret = rotateImage(matrix);
        for(int i = 0; i < ret.length; ++i) {
            for (int j = 0; j < ret.length; ++j) {
                System.out.print(ret[i][j]);
            }
        }
        System.out.println(ret);

    }

    public static int[][] rotateImage(int[][] matrix) {
        if(matrix == null || matrix[0].length <=0 )
            throw  new RuntimeException();

        final int n = matrix.length;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n - i; ++j) {
                swap(matrix, i, j, n - 1 - i, n - 1 -j);
            }
        }

        for(int i = 0; i < n /2 ; ++i) {
            for(int j = 0; j < n; ++j) {
                swap (matrix, i, j, n - 1 - i, j);
            }
        }
        return matrix;
    }

    private static void swap(int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }
}
