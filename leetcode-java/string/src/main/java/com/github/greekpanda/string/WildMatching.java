package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Wildcard Matching
 * 描述
 * Implement wildcard pattern matching with support for '?' and '*' .
 * '?' Matches any single character. '*' Matches any sequence of characters (including the empty
 * sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → fals
 * 主要是 '*' 的匹配问题。 p 每遇到一个 '*' ，就保留住当前 '*' 的坐标和 s 的坐标，然后 s 从前往
 * 后扫描，如果不成功，则 s++ ，重新扫描。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 08:11
 */
@Slf4j
public class WildMatching {
    public static void main(String[] args) {
        log.info(String.valueOf(wildMatching("aa", "a")));
        log.info(String.valueOf(wildMatching("aa", "aa")));
        log.info(String.valueOf(wildMatching("aa", "*")));
        log.info(String.valueOf(wildMatching("aa", "a*")));
        log.info(String.valueOf(wildMatching("ab", "a*")));
        log.info(String.valueOf(wildMatching("ab", "?*")));
        log.info(String.valueOf(wildMatching("aab", "c*a*b")));

        log.info("-----------------------------");

        log.info(String.valueOf(wildMatching1("aa", "a")));
        log.info(String.valueOf(wildMatching1("aa", "aa")));
        log.info(String.valueOf(wildMatching1("aa", "*")));
        log.info(String.valueOf(wildMatching1("aa", "a*")));
        log.info(String.valueOf(wildMatching1("ab", "a*")));
        log.info(String.valueOf(wildMatching1("ab", "?*")));
        log.info(String.valueOf(wildMatching1("aab", "c*a*b")));
    }

    public static boolean wildMatching(String s, String p) {
        if (s.isEmpty() || p.isEmpty())
            return false;

        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length())
            return true;
        if (i == s.length() || j == p.length())
            return false;

        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*')
                ++j;
            if (j == p.length())
                return true;
            while (i < p.length() && isMatch(s, i, p, j))
                ++i;
            return i < s.length();
        } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            return isMatch(s, ++i, p, ++j);
        } else
            return false;
    }

    public static boolean wildMatching1(String s, String p) {
        if (s.isEmpty() || p.isEmpty())
            return false;

        int i = 0, j = 0;
        int ii = -1, jj = -1;

        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                while (j < p.length() && p.charAt(j) == '*')
                    ++j;
                if (j == p.length())
                    return true;
                ii = i;
                jj = j;
            }
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                ++i;
                ++j;
            } else {
                if (ii == -1)
                    return false;
                ++ii;
                i = ii;
                j = jj;
            }

        }
        while (j < p.length() && p.charAt(j) == '*')
            ++j;
        return i == s.length() && j == p.length();
    }
}
