package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Additive Number
 * 描述
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each
 * subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5,
 * 8 .
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199 .
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02,
 * 3 is invalid.
 * Given a string containing only digits '0'-'9' , write a function to determine if it's an additive number.
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 分析
 * 这是一个多阶段决策问题，且必须走到字符串最后一个字符才能得出结论，因此适合用深搜或DP。
 * 再仔细想一下状态转换图，每次索引变化一下，就跟之前的完全没有重复，因此状态转换图是一颗树，不
 * 是DAG，因此不存在重叠子问题，因此排除DP，本题应该用深搜
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 13:47
 */
@Slf4j
public class AdditiveNumber {
    public static void main(String[] args) {

    }

    public static boolean isAdditiveNumber(final String nums) {
        for (int i = 1; i < (nums.length() >> 1); i++) {
            if (nums.charAt(0) == '0' && i > 1) {
                continue;
            }
            for (int j = i + 1; j < nums.length(); j++) {
                if (nums.charAt(i) == '0' && j - i > 1) {
                    continue;
                }

                if (dfs(nums, 0, i, j) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(final String nums, int i, int j, int k) {
        long num1 = Long.parseLong(nums.substring(i, j));
        long num2 = Long.parseLong(nums.substring(j, k));

        final String addition = String.valueOf(num1 + num2);
        if (!nums.substring(k).startsWith(addition)) {
            return false;
        }

        if (k + addition.length() == nums.length()) {
            return true;
        }

        return dfs(nums, j, k, k + addition.length());
    }
}
