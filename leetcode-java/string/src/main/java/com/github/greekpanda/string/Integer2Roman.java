package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 08:51
 */
@Slf4j
public class Integer2Roman {
    public static void main(String[] args) {
        log.info(int2Roman(1000));
        log.info(int2Roman(3999));
        log.info(int2Roman(15));
    }

    public static String int2Roman(int num) {
        if (num < 1 || num > 3999)
            return null;

        final int radix[] = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        final String symbol[] = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; num > 0; ++i) {
            int count = num / radix[i];
            num %= radix[i];
            for(; count > 0; --count)
                sb.append(symbol[i]);
        }
        return sb.toString();
    }
}
