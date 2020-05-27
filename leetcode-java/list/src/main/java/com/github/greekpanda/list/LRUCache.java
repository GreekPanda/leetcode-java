package com.github.greekpanda.list;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * LRU Cache
 * 描述
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise
 * return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its
 * capacity, it should invalidate the least recently used item before inserting a new item.
 * 分析
 * 为了使查找、插入和删除都有较高的性能，这题的关键是要使用一个双向链表和一个HashMap，因为：
 * HashMap保存每个节点的地址，可以基本保证在 O(1) 时间内查找节点
 * 双向链表能后在 O(1) 时间内添加和删除节点，单链表则不行
 * 具体实现细节：
 * 越靠近链表头部，表示节点上次访问距离现在时间最短，尾部的节点表示最近访问最少
 * 访问节点时，如果节点存在，把该节点交换到链表头部，同时更新hash表中该节点的地址
 * 插入节点时，如果cache的size达到了上限capacity，则删除尾部节点，同时要在hash表中删除对应的
 * 项；新节点插入链表头部
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/27 10:42
 */
@Slf4j
public class LRUCache {
    private Integer capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node end;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return Integer.MAX_VALUE;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() > capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);

            map.put(key, newNode);
        }

    }

    private void remove(Node n) {
        if (n.prev != null)
            n.prev.next = n.next;
        else
            head = n.next;

        if (n.next != null)
            n.next.prev = n.prev;
        else
            end = n.prev;
    }

    private void setHead(Node n) {
        n.next = head;
        n.prev = null;

        if (head != null)
            head.prev = n;

        head = n;

        if (end == null)
            end = head;
    }

    static class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {

    }
}


