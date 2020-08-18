package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * 描述
 * Given two integers n and k , return all possible combinations of k numbers out of 1 ... n .
 * For example, If n = 4 and k = 2 , a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/18 22:46
 */
@Slf4j
public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> ret = combination(n, k);
        log.info(String.valueOf(ret));
    }

    public static List<List<Integer>> combination(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, 0, path, result);
        return result;
    }

    private static void dfs(int n, int k, int start, int cur, List<Integer> path, List<List<Integer>> result) {
        if(cur == k) {
            result.add(new ArrayList<>(path));
        }

        for(int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, cur + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
