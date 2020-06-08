package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * 描述
 * Given a pattern and a string str , find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a nonempty word in str .
 * Examples:
 * 1. pattern = "abba" , str = "dog cat cat dog" should return true.
 * 2. pattern = "abba" , str = "dog cat cat fish" should return false.
 * 3. pattern = "aaaa" , str = "dog cat cat dog" should return false.
 * 4. pattern = "abba" , str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters
 * separated by a single space.
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/8 08:41
 */
@Slf4j
public class WordPattern {
    public static void main(String[] args) {
        log.info(String.valueOf(wordPattern("abba", "dog cat cat dog")));
        log.info(String.valueOf(wordPattern("abba", "dog cat cat fish")));
        log.info(String.valueOf(wordPattern("aaaa", "dog cat cat dog")));
        log.info(String.valueOf(wordPattern("abba", "dog dog dog dog")));

    }

    //p is pattern,
//    public static boolean wordPattern(final String p, final String s) {
//        if (p.isEmpty() || s.isEmpty() || p.length() != s.length())
//            return false;
//
//        String[] worlds = s.split(" ");
//        final Map<Character, String> map1 = new HashMap<>();
//        final Map<String, Character> map2 = new HashMap<>();
//
//        for (int i = 0; i < worlds.length; ++i) {
//            final Character key1 = p.charAt(i);
//            if (map1.containsKey(key1)) {
//                final String value = map1.get(key1);
//                if (value.equals(worlds[i]))
//                    return false;
//            } else {
//                map1.put(key1, worlds[i]);
//            }
//
//            final String key2 = worlds[i];
//            if (map2.containsKey(key2)) {
//                final char c = map2.get(key2);
//                if (c != p.charAt(i))
//                    return false;
//            } else {
//                map2.put(key2, p.charAt(i));
//            }
//        }
//        return true;
//    }

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        final Map<Character, String> map1 = new HashMap<>();
        final Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            final Character key1 = pattern.charAt(i);
            if (map1.containsKey(key1)) {
                final String value = map1.get(key1);
                if (!value.equals(words[i])) return false;
            } else {
                map1.put(key1, words[i]);
            }
            final String key2 = words[i];
            if (map2.containsKey(key2)) {
                final char value = map2.get(key2);
                if (value != pattern.charAt(i)) return false;
            } else {
                map2.put(key2, pattern.charAt(i));
            }
        }
        return true;
    }
}