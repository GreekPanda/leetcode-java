package com.github.greekpanda.search;

import java.util.*;
import java.util.function.Function;

/**
 * Word Ladder
 * 描述
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" , return its length 5 .
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/19 07:26
 */
public class WordLadder {
    public static void main(String[] args) {

    }

    public static int wordLadder(String begin, String end, Set<String> words) {
        if (words == null) {
            throw new RuntimeException();
        }

        Queue<State> q = new LinkedList<>();
        HashSet<State> visited = new HashSet<>();

        final Function<State, Boolean> isValid = (State s) -> words.contains(s.word) || s.word.equals(end);
        final Function<State, Boolean> isTarget = (State s) -> s.word.equals(end);
        final Function<State, HashSet<State>> isExtend = (State s) -> {
            HashSet<State> result = new HashSet<>();

            char[] array = s.word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                final char old = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == array[i]) {
                        continue;
                    }

                    array[i] = c;
                    State state = new State(new String(array), s.level + 1);
                    if (isValid.apply(state) && !visited.contains(state)) {
                        result.add(state);
                    }
                    array[i] = old;
                }
            }
            return result;
        };

        State startState = new State(begin, 0);
        q.offer(startState);
        visited.add(startState);
        while (!q.isEmpty()) {
            State state = q.poll();
            if (isTarget.apply(state)) {
                return state.level + 1;
            }
            HashSet<State> newStates = isExtend.apply(state);
            for (State newState : newStates) {
                q.offer(newState);
                visited.add(newState);
            }
        }

        return 0;
    }

    static class State {
        String word;
        int level;

        public State(String word, int level) {
            this.word = word;
            this.level = level;
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (this.hashCode() != o.hashCode()) {
                return false;
            }

            if (!(o instanceof State)) {
                return false;
            }

            return this.word.equals(((State) o).word);
        }

    }
}
