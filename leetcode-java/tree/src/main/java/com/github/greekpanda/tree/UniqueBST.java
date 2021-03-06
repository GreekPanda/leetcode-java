package com.github.greekpanda.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * Unique Binary Search Trees
 * 描述
 * Given n , how many structurally unique BST's (binary search trees) that store values 1...n ?
 * For example, Given n = 3 , there are a total of 5 unique BST's.
 * 1 3 3 2 1
 * \ / / / \ \
 * 3 2 1 1 3 2
 * / / \ \
 * 2 1 2 3
 * 分析
 * 如果把上例的顺序改一下，就可以看出规律了。
 * 1 1 2 3 3
 * \ \ / \ / /
 * 3 2 1 3 2 1
 * / \ / \
 * 2 3 1 2
 * 比如，以1为根的树的个数，等于左子树的个数乘以右子树的个数，左子树是0个元素的树，右子树是2个元
 * 素的树。以2为根的树的个数，等于左子树的个数乘以右子树的个数，左子树是1个元素的树，右子树也是1
 * 个元素的树。依此类推。
 * 当数组为 1,2,3,...,n 时，基于以下原则的构建的BST树具有唯一性： \textbf{以i为根节点的树，其左子
 * 树由[1, i-1]构成， 其右子树由[i+1, n]构成。}
 * 定义 f(i) 为以 [1,i] 能产生的Unique Binary Search Tree的数目，则
 * 如果数组为空，毫无疑问，只有一种BST，即空树， f(0)=1 。
 * 如果数组仅有一个元素{1}，只有一种BST，单个节点， f(1)=1 。
 * 如果数组有两个元素{1,2}， 那么有如下两种可能
 * 1 2
 * \ /
 * 2 1
 * f(2) = f(0) ∗ f(1) , when 1 as root
 * +f(1) ∗ f(0) , when 2 as root
 * 再看一看3个元素的数组，可以发现BST的取值方式如下：
 * f(3) = f(0) ∗ f(2) , when 1 as root
 * Unique Binary Search Trees
 * 204
 * +f(1) ∗ f(1) , when 2 as root
 * +f(2) ∗ f(0) , when 3 as root
 * 所以，由此观察，可以得出 f 的递推公式为
 * f(i) = f(k − 1) × f(i − k)
 * 至此，问题划归为一维动态规划
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/21 08:38
 */
@Slf4j
public class UniqueBST {
    public static void main(String[] args) {

    }

    //TODO:
    public static int uniqueBST(int n) {
        return Integer.MAX_VALUE;
    }
}
