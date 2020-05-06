package com.github.greekpanda.array;

import java.util.Arrays;

/**
 * Valid Sudoku
 * 描述
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules
 * http://sudoku.com.au/TheRules.aspx .
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.' .
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 23:11
 */
public class Sudoku {
    public static void main(String[] args) {

        char[][] board = new char[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {11, 12, 13, 14, 15, 16, 17, 18, 19},
                {21, 22, 23, 24, 25, 26, 27, 28, 29},
                {32, 32, 33, 34, 35, 36, 37, 38, 39}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length <= 0)
            throw new RuntimeException();

        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);

            //check all rows
            for (int j = 0; j < 9; j++) {
                if (!check(board[i][j], used)) {
                    return false;
                }
            }

            Arrays.fill(used, false);
            //check all columns
            for (int j = 0; j < 9; j++) {
                if (!check(board[j][i], used)) {
                    return false;
                }
            }
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Arrays.fill(used, false);

                for (int i = r * 3; i < r * 3 + 3; ++i) {
                    for (int j = c * 3; j < c * 3 + 3; ++j) {
                        if (!check(board[i][j], used))
                            return false;
                    }
                }
            }
        }

        return true;

    }

    private static boolean check(char board, boolean[] used) {
        if (board == '.') return true;
        if (used[board - '1']) return false;
        return used[board - '1'] = true;
    }

}
