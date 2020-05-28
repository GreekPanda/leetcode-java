package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Regular Expression Matching
 * 描述
 * Implement regular expression matching with support for '.' and '*' .
 * '.' Matches any single character. '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → tru
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 22:55
 */
@Slf4j
public class RegularExpressionMatch {
    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        log.info(String.valueOf(isMatch(s1, p1)));

        String s2 = "aa", p2 = "aa";
        log.info(String.valueOf(isMatch(s2, p2)));

        log.info(String.valueOf(isMatch("aaa", "aa")));
        log.info(String.valueOf(isMatch("aa", "a*"))); //→ true
        log.info(String.valueOf(isMatch("aa", ".*"))); //→ true
        log.info(String.valueOf(isMatch("ab", ".*"))); //→ true
        log.info(String.valueOf(isMatch("aab", "c*a*b")));// → true

    }

    public static boolean isMatch(final String str, final String pattern) {
        if (str.isEmpty() || pattern.isEmpty())
            return false;

        return isMatch(str, 0, pattern, 0);
    }

    private static boolean isMatch(final String s, int sBegin, final String pattern, int pBegin) {
        if (pBegin == pattern.length())
            return sBegin == s.length();

        final char c = pattern.charAt(pBegin);
        if (pBegin == pattern.length() - 1 || pattern.charAt(pBegin + 1) != '*') {
            if (matchFirst(s, sBegin, pattern, pBegin))
                return isMatch(s, sBegin + 1, pattern, pBegin + 1);
            else
                return false;
        } else {
            if (isMatch(s, sBegin, pattern, pBegin + 2))
                return true;
            while (matchFirst(s, sBegin, pattern, pBegin))
                if (isMatch(s, sBegin++, pattern, pBegin))
                    return true;
            return false;
        }

    }

    private static boolean matchFirst(final String s, int sBegin, final String p, int pBegin) {
        if (pBegin == p.length()) return s.length() == sBegin;
        if (sBegin == s.length()) return p.length() == pBegin;

        return s.charAt(sBegin) == '.' || s.charAt(sBegin) == p.charAt(pBegin);
    }
}
