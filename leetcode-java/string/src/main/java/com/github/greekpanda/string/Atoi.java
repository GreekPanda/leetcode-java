package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * String to Integer (atoi)
 * 描述
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and
 * ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are
 * responsible to gather all the input requirements up front.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign followed
 * by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored
 * and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such
 * sequence exists because either str is empty or it contains only whitespace characters, no conversion is
 * performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range
 * of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 16:17
 */
@Slf4j
public class Atoi {
    public static void main(String[] args) {
        String str1 = "-3924x8fc";
        int ret1 = atoi(str1);
        System.out.println(ret1);
        String str2 = "++c";
        int ret2 = atoi(str2);
        System.out.println(ret2);

    }

    public static int atoi(String str) {
        if (str.isEmpty())
            throw new RuntimeException("str can't be null");

        int num = 0;
        int sign = 1;
        final int n = str.length();
        if (n == 0)
            return 0;

        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        for (; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if (num > Integer.MAX_VALUE / 10
                    || ((num == Integer.MAX_VALUE / 10) && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + str.charAt(i) - '0';
        }
        return num * sign;
    }
}
