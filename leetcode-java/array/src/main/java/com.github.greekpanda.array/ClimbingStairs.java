package com.github.greekpanda.array;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 分析
 * 设 f(n) 表示爬 n 阶楼梯的不同方法数，为了爬到第 n 阶楼梯，有两个选择：
 * 从第 n-1 阶前进1步；
 * 从第 n-1 阶前进2步；
 * 因此，有 f(n)=f(n-1)+f(n-2) 。
 * 这是一个斐波那契数列。
 * 方法1，递归，太慢；方法2，迭代。
 * 方法3，数学公式。斐波那契数列的通项公式为 a = − 。
 *
 * @author GreePanda
 * @version 1.0
 * @date 2020/5/7 07:27
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int ret1 = climbStairs1(5);
        int ret = climbStairs(5);
        System.out.println(ret1 + "\t" + ret);
    }

    public static int climbStairs(int n) {
        int p = 0;
        int q = 1;
        for (int i = 0; i <= n; ++i) {
            int tmp = q;
            q += p;
            p = tmp;
        }
        return q;
    }

    public static int climbStairs1(int n) {
        final double s = Math.sqrt(5);
       // return (int) Math.floor((Math.pow((1 + s) / 2, n + 1) + Math.pow((1 - s) / 2, n + 1)) / s + 0.5);
        return (int) Math.floor((Math.pow((1 + s) / 2, n + 1) +
                Math.pow((1 - s) / 2, n + 1)) / s + 0.5);
    }
}
