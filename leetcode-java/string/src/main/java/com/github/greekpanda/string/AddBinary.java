package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Add Binary
 * 描述
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 22:13
 */
@Slf4j
public class AddBinary {
    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        String ret = addBinary(a, b);
        log.info(ret);

    }
    public static String addBinary(final String a, final String b) {
        if(a.isEmpty() || b.isEmpty())
            return null;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry > 0) {
            int v1 = i < 0 ? 0 : a.charAt(i--) - '0';
            int v2 = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = v1 + v2 + carry;
            sb.insert(0, Character.forDigit(sum % 2, 10));
            carry = sum / 2;
        }
        return sb.toString();
    }
}
