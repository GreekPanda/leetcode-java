package com.github.greekpanda.tree;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/29 07:56
 */
public class SegmentTreeNode {
    private int begin;
    private int end;
    private int sum;
    private SegmentTreeNode left;
    private SegmentTreeNode right;

    public SegmentTreeNode(int begin, int end, int sum) {
        this.begin = begin;
        this.end = end;
        this.sum = sum;
    }

    public SegmentTreeNode(int begin, int end) {
        this(begin, end, 0);
    }

}
