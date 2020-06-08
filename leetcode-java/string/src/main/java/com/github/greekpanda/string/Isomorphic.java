package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/8 08:31
 */
@Slf4j
public class Isomorphic {
    public static void main(String[] args) {

        log.info(String.valueOf(isomorphic("add", "egg")));
        log.info(String.valueOf(isomorphic("foo", "bar")));
    }

    public static boolean isomorphic(final String s, final String t) {
        if(s.isEmpty() || t.isEmpty() || s.length() != t.length())
            return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            final char c1 = s.charAt(i);
            final char c2 = t.charAt(i);

            if(map1.containsKey(c1)) {
                if(map1.get(c1) != c2) {
                    return false;
                } else {
                    map1.put(c1, c2);
                }
            }

            if(map2.containsKey(c2)) {
                if(map2.get(c2) != c1) {
                    return false;
                } else {
                    map2.put(c2, c1);
                }
            }
        }
        return true;
    }
}
