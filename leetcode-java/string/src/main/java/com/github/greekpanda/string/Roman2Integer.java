package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 分析
 * 从前往后扫描，用一个临时变量记录分段数字。
 * 如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如 IV = 5 – 1 ；否则，将当
 * 前值加入到结果中，然后开始下一段记录。比如 VI = 5 + 1, II=1+1
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 08:56
 */
@Slf4j
public class Roman2Integer {
    public static void main(String[] args) {
        final String s = "XV";
        log.info(String.valueOf(roman2Int(s)));

    }

    public static int roman2Int(String s) {
        if (s.isEmpty())
            throw new RuntimeException("error input");

        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && map(s.charAt(i)) > map(s.charAt(i - 1)))
                result += map(s.charAt(i)) - 2 * map(s.charAt(i - 1));
            else
                result += map(s.charAt(i));
        }
        return result;
    }

    private static int map(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
