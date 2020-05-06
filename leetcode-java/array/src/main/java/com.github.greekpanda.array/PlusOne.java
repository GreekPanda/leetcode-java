package com.github.greekpanda.array;

/**
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/7 07:09
 */
public class PlusOne {
    public static void main(String[] args) {

        int[] digits = new int[] {9,9,9,9};
        int[] ret = plusOne(digits);
        for(int n : ret) {
            System.out.print(n + "\t");
        }
    }

    public static int[] plusOne(int[] digits) {
        return add(digits, 1);
    }

    private static int[] add(int[] digits, int n) {
        if (digits == null || digits.length <= 0)
            throw new RuntimeException();

        int c = n;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }

        if (c > 0) {
            int[] tmp = new int[digits.length + 1];
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            tmp[0] = c;
            return tmp;
        } else {
            return digits;
        }
    }
}
