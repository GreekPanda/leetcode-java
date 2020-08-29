package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * 描述
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab" , Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * 分析
 * 在每一步都可以判断中间结果是否为合法结果，用回溯法。
 * 一个长度为n的字符串，有 n-1 个地方可以砍断，每个地方可断可不断，因此复杂度为O(2
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 14:04
 */
@Slf4j
public class PalindromePartition {
    public static void main(String[] args) {

    }

    public static List<List<String>> palindromePartition(final String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, result, path, 0, 1);
        return result;
    }

    private static void dfs(String s, List<List<String>> result, List<String> path, int prev, int start) {
        if (start == s.length()) {
            if (isPalindrome(s, prev, start - 1)) {
                path.add(s.substring(prev, start));
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        }
        dfs(s, result, path, prev, start + 1);

        if (isPalindrome(s, prev, start - 1)) {
            path.add(s.substring(prev, start));
            dfs(s, result, path, start, start + 1);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            ++start;
            --end;
        }
        return start >= end;
    }
}
