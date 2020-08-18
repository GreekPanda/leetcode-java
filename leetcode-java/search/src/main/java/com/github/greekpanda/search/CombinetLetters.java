package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * 描述
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"] .
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/18 22:55
 */
@Slf4j
public class CombinetLetters {
    private static final String[] keyboard = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        List<String> ret = null;
        for (String s : keyboard) {
            ret = letterCombination(s);
        }
        log.info(String.valueOf(ret));
    }

    public static List<String> letterCombination(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        dfs(digits, 0, "", result);

        return result;
    }

    private static void dfs(String digits, int cur, String path, List<String> result) {
        if (cur == digits.length()) {
            return;
        }

        final String str = keyboard[digits.charAt(cur) - '0'];
        for (char c : keyboard[digits.charAt(cur) - '0'].toCharArray()) {
            dfs(digits, cur + 1, path + c, result);
        }
    }
}
