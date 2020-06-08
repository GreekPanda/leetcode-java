package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

/**
 * Length of Last Word
 * 描述
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ' , return the
 * length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, Given s = "Hello World" , return 5.
 * 分析
 * 模拟。先从右到左找到第一个字母，然后从右到左找到第一个非字母，二者的距离就是最后一个word的长
 * 度。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/8 08:07
 */
@Slf4j
public class LengthOfLastWord {
    public static void main(String[] args) {
        final String s = "hello world";
        log.info(String.valueOf(lengthLastWord(s)));

        log.info(String.valueOf(lengthLastWord("what's are doing now?")));
    }

    public static int lengthLastWord(final String str) {
        if (str.isEmpty())
            return 0;

        final Predicate<Character> isAlphabet = new Predicate<Character>() {
            @Override
            public boolean test(Character c) {
                return Character.isAlphabetic(c);
            }
        };

        final Predicate<Character> isNotAlphabet = new Predicate<Character>() {
            @Override
            public boolean test(Character character) {
                return !Character.isAlphabetic(character);
            }
        };

        int j = findFromRight2Left(str, str.length() - 1, isAlphabet);
        int i = findFromRight2Left(str, j, isNotAlphabet);

        return j - i;


    }

    private static int findFromRight2Left(final String s, int fromIndex, Predicate p) {
        for (int i = fromIndex; i >= 0; i--) {
            if (p.test(s.charAt(i)))
                return i;
        }
        return -1;
    }
}
