package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Longest Common Prefix
 * 描述
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 分析
 * 从位置0开始，对每一个位置比较所有字符串，直到遇到一个不匹配
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 08:32
 */
@Slf4j
public class LongestCommonPrefix {
    public static void main(String[] args) {
        final String[] s = new String[]{"aaa", "bbb", "aaa", "bbbbb", "aa"};
        String ret1 = longestCommonPrefix1(s);
        String ret2 = longestCommonPrefix(s);

        log.info(ret1);
        log.info(ret2);
    }

    //纵向比较
    public static String longestCommonPrefix(String[] s) {
        if(s == null || s.length <= 0)
            return null;

        for(int j = 0; j < s[0].length(); ++j) {
            for(int i = 1; i < s.length; ++i) {
                if(j == s[i].length() || s[i].charAt(j) != s[0].charAt(j))
                    return s[0].substring(0, j);
            }
        }
        return s[0];
    }

    //横向比较
    public static String longestCommonPrefix1(String[] s) {
        if(s == null || s.length <= 0)
            return null;

        int right_most = s[0].length();
        for(int i = 0; i < s.length; ++i) {
            for(int j = 0; j < right_most; ++j) {
                if(j == s[i].length() || s[i].charAt(j) == s[0].charAt(j)) {
                    right_most = j;
                }
            }
        }
        return s[0].substring(0, right_most);
    }
}
