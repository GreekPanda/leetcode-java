package com.github.greekpanda.string;

/**
 * mplement strStr()
 * 描述
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 分析
 * 暴力算法的复杂度是 O(m*n) ，代码如下。更高效的的算法有KMP算法、Boyer-Mooer算法和Rabin-Karp
 * 算法
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 15:40
 */
public class Strstr {
    public static void main(String[] args) {

    }

    //Use KMP to implement it
    public static String strStr(final String hayStack, final String needle) {
        if(hayStack.isEmpty() || needle.isEmpty())
            return null;
        return kmp(hayStack, needle);
    }

    private static String kmp(final String text, final String pattern) {
        int i;
        int j = -1;
        final int n = text.length();
        final int m = pattern.length();

        if(n == 0 && m == 0)
            return null;

        //TODO:没有理解KMP原理
        return null;
    }
}
