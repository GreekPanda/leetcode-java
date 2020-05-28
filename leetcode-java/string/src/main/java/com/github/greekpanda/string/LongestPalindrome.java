package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Longest Palindromic Substring
 * 描述
 * Given a string S , find the longest palindromic substring in S . You may assume that the maximum
 * length of S is 1000, and there exists one unique longest palindromic substring.
 * 分析
 * 最长回文子串，非常经典的题。
 * 思路一：暴力枚举，以每个元素为中间元素，同时从左右出发，复杂度 O(n^2) 。
 * 思路二：记忆化搜索，复杂度 O(n^2) 。设 f[i][j] 表示[i,j]之间的最长回文子串，递推方程如下：
 * f[i][j] = if (i == j) S[i]
 * if (S[i] == S[j] && f[i+1][j-1] == S[i+1][j-1]) S[i][j]
 * else max(f[i+1][j-1], f[i][j-1], f[i+1][j])
 * 思路三：动规，复杂度 O(n^2) 。设状态为 f(i,j) ，表示区间[i,j]是否为回文串，则状态转移方程为
 * f(i, j) =
 * 思路四：Manacher’s Algorithm, 复杂度 O(n) 。详细解释见 http://leetcode.com/2011/11/longestpalindromic-substring-part-ii.html。
 * 备忘录法
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 22:53
 */
@Slf4j
public class LongestPalindrome {
    public static void main(String[] args) {
        //TODO:
    }
}
