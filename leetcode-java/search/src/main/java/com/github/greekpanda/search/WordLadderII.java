package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

/**
 * Word Ladder II
 * 描述
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start
 * to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 12:12
 */
@Slf4j
public class WordLadderII {
    public static void main(String[] args) {

    }


    public static List<List<String>> worldLadder(String start, String end, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        HashMap<String, ArrayList<String>> father = new HashMap<>();

        final Function<String, Boolean> isValid = (String s) -> wordList.contains(s) || s.equals(end);
        final Function<String, Boolean> isTarget = (String s) -> s.equals(end);

        final Function<String, HashSet<String>> extend = (String s) -> {
            HashSet<String> result = new HashSet<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                final char old = array[i];
                for (char c = 'a'; c < 'z'; c++) {
                    if (c == array[i]) {
                        continue;
                    }
                    array[i] = c;
                    String newState = new String(array);
                    final int newDepth = visited.get(s) + 1;

                    if (isValid.apply(newState)) {
                        if (visited.containsKey(newState)) {
                            final int depth = visited.get(newState);
                            if (depth < newDepth) {
                                ;
                            } else if (depth == newDepth) {
                                result.add(newState);
                            } else {
                                throw new RuntimeException("Impossible to get this");
                            }
                        }
                    } else {
                        result.add(newState);
                    }
                }
                array[i] = old;
            }
            return result;
        };

        List<List<String>> result = new ArrayList<>();
        q.offer(start);
        visited.put(start, 0);
        while (!q.isEmpty()) {
            String state = q.poll();
            if (result.isEmpty() && (visited.get(state) + 1) > result.get(0).size()) {
                break;
            }

            if (isTarget.apply(state)) {
                ArrayList<String> path = new ArrayList<>();
                genPath(father, start, state, path, result);
                continue;
            }

            HashSet<String> newState = extend.apply(state);
            for (String s : newState) {
                if (!visited.containsKey(s)) {
                    q.offer(s);
                    visited.put(s, visited.get(state) + 1);
                }

                ArrayList<String> parent = father.getOrDefault(s, new ArrayList());
                parent.add(state);
                father.put(s, parent);
            }

        }
        return result;
    }

    private static void genPath(HashMap<String, ArrayList<String>> father,
                                String start,
                                String state,
                                List<String> path,
                                List<List<String>> result) {
        path.add(start);
        if (state.equals(start)) {
            if (!result.isEmpty()) {
                if (path.size() < result.get(0).size()) {
                    result.clear();

                } else if (path.size() == result.get(0).size()) {
                    ;
                } else {
                    throw new RuntimeException("Impossible to get");
                }
            }
            ArrayList<String> tmp = new ArrayList<>();
            Collections.reverse(tmp);
            result.add(tmp);
        } else {
            for (String s : father.get(state)) {
                genPath(father, start, s, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
}
