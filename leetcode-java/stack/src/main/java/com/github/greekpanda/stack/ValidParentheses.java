package com.github.greekpanda.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Valid Parentheses
 * 描述
 * Given a string containing just the characters '(' , ')' , '{' , '}' , '[' and ']' , determine if
 * the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "
 * ([)]" are not.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/9 09:04
 */
@Slf4j
public class ValidParentheses {
    public static void main(String[] args) {

        log.info(String.valueOf(isValid("()[]{}")));
        log.info(String.valueOf(validParentheses("()[]}")));
    }

    public static boolean validParentheses(final String s) {
        if (s == null || s.length() == 0)
            return false;

        final String left = "{[(";
        final String right = "}])";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (left.indexOf(c) != -1) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()
                        && stack.peek() == left.charAt(right.indexOf(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isValid(String s) {
        final String left = "([{";
        final String right = ")]}";
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (left.indexOf(c) != -1) {
                stk.push(c);
            } else {
                if (!stk.isEmpty() &&
                        stk.peek() == left.charAt(right.indexOf(c)))
                    stk.pop();
                else
                    return false;
            }
        }
        return stk.empty();
    }
}
