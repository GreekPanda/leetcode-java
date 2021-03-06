package com.github.greekpanda.array;

/**
 * Gas Station
 * 描述
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i] .
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its
 * next station ( i+1 ). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note: The solution is guaranteed to be unique.
 * 分析
 * 首先想到的是O(N )的解法，对每个点进行模拟。
 * O(N) 的解法是，设置两个变量， sum 判断当前的指针的有效性； total 则判断整个数组是否有解，有
 * 就返回通过 sum 得到的下标，没有则返回-1。
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/8 08:58
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,6,8,19,23,4};
        int[] cost = {11,3,9,18,6,17};

        int ret = completeCircuit(gas, cost);
        System.out.println(ret);
    }

    public static int completeCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length <= 0 || cost == null || cost.length <= 0)
            throw new RuntimeException();

        int total = 0;
        int j = -1;

        for (int i = 0, sum = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }
        return total >= 0 ? j + 1 : -1;
    }
}
