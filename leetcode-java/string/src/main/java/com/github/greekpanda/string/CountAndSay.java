package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11 .
 * 11 is read off as "two 1s" or 21 .
 * 21 is read off as "one 2" , then "one 1" or 1211 .
 * Given an integer n , generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 09:19
 */
@Slf4j
public class CountAndSay {
    public static void main(String[] args) {
        log.info(countAndSay(111));
        log.info(countAndSay(12));

    }

    public static String countAndSay(int num) {
        if (num < 0)
            return null;
        String s = "1";
        while (--num > 0)
            s = getNext(s);

        return s;
    }

    private static String getNext(final String s) {
        if (s.isEmpty())
            return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int j = notEqual(s, i);
            sb.append(j - i);
            sb.append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }

    private static int notEqual(final String s, int index) {
        int i = index;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(index))
                break;
        }
        return i;
    }
}
