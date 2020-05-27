package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

/**
 * Valid Palindrome
 * 描述
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 * cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an
 * interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 15:33
 */
@Slf4j
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean ret1 = isValidPalindrome(str);
        log.info(String.valueOf(ret1));
        String str1 = "race a car";
        boolean ret2 = isValidPalindrome(str1);
        log.info(String.valueOf(ret2));

    }

    public static boolean isValidPalindrome(String str) {
        if(str == null || str.length() <= 0)
            return false;

        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                ++left;
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                --right;
            } else if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
