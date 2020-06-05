package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Anagrams
 * 描述
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 分析
 * Anagram（ 回文构词法） 是指打乱字母顺序从而得到新的单词，比如 "dormitory" 打乱字母顺序会变成
 * "dirty room" ， "tea" 会变成 "eat" 。
 * 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。因此，将几
 * 个单词按照字母顺序排序后，若它们相等，则它们属于同一组 anagrams 。
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/4 09:40
 */
@Slf4j
public class Anagrams {
    public static void main(String[] args) {
        final String[] s = new String[]{"dormitory"};
        List<List<String>> result = anagrams(s);
        log.info(String.valueOf(result));

    }

    public static List<List<String>> anagrams(String[] s) {
        if(s == null || s.length <= 0)
            return null;

        final HashMap<String, ArrayList<String>> group = new HashMap<>();
        for(String s1 : s) {
            char[] tmp = s1.toCharArray();
            Arrays.sort(tmp);

            final String key = new String(tmp);
            if(!group.containsKey(key)) {
                group.put(key, new ArrayList<>());
            }
            group.get(key).add(s1);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> m : group.entrySet()) {
            final ArrayList<String> list = m.getValue();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
}
