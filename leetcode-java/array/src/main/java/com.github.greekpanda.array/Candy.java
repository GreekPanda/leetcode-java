package com.github.greekpanda.array;

/**
 * Candy
 * 描述
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/8 09:10
 */
public class Candy {
    public static void main(String[] args) {
        int[] rating = {1,3,7,2,11,23,45};
        int ret = candy(rating);
        System.out.println(ret);
    }

    public static int candy(int[] rating) {
        if (rating == null || rating.length <= 0)
            throw new RuntimeException();

        final int n = rating.length;
        final int[] increment = new int[n];

        for (int i = 1, inc = 1; i < n; i++) {
            if (rating[i] > rating[i - 1]) {
                increment[i] = Math.max(inc++, increment[i]);
            } else {
                inc++;
            }
        }

        for (int i = n - 2, inc = 1; i >= 0; i--) {
            if (rating[i] > rating[i + 1]) {
                increment[i] = Math.max(inc++, increment[i]);
            } else {
                inc = 1;
            }
        }
        int sum = n;
        for(int i : increment)
            sum += i;

        return sum;

    }
}
