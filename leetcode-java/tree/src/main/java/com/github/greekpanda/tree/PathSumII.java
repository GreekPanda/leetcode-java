package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/22 09:06
 */
@Slf4j
public class PathSumII {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        pathSum(root, sum, cur, result);

        return result;
    }

    private static void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (root == null)
            return;

        cur.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<>(cur));
            }
        }

        pathSum(root.left, sum - root.val, cur, result);
        pathSum(root.right, sum - root.val, cur, result);

        cur.remove(cur.size() - 1);
    }
}
