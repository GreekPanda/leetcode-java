package com.github.greekpanda.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/6 22:49
 */
public class kthPermutation {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        String ret = getKthPermutation(n, k);
        System.out.println(ret);
    }

    public static String getKthPermutation(int n, int k) {
        if (n <= 0)
            throw new RuntimeException();

        k--;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            integerList.add(i);
        }

        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }

        StringBuilder sb = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            int indexList = k / factorial;
            sb.append(integerList.get(indexList));
            integerList.remove(indexList);

            k %= factorial;
            if (times != 0) {
                factorial /= times;
            }
            times--;

        }

        return sb.toString();
    }
}
