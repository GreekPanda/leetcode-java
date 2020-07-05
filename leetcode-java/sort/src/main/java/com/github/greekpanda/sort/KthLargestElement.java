package com.github.greekpanda.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Kth Largest Element in an Array
 * 描述
 * Find the k -th largest element in an unsorted array.
 * For example, given [3,2,1,5,6,4] and k = 2 , return 5.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 分析
 * 这题是一道很好的面试题目，
 * 题目短小，很快就能说清题意
 * 有很多种解法。从简单到复杂的解法都有，梯度均匀。
 * 不需要预先知道特殊领域知识。
 * 这题有很多思路：
 * 1. 按从大到小全排序，然后取第 k 个元素，时间复杂度 O(nlogn) ，空间复杂度 O(1)
 * 2. 利用堆进行部分排序。维护一个大根堆，将数组元素全部压入堆，然后弹出 k 次，第 k 个就是答
 * 案。时间复杂度 O(klogn) ，空间复杂度 O(n)
 * 3. 选择排序，第 k 次选择后即可得到第 k 大的数，时间复杂度 O(nk) ，空间复杂度 O(1)
 * 4. 堆排序，维护一个 k 大小的小根堆，将数组中的每个元素与堆顶元素进行比较，如果比堆顶元素大，
 * 则删除堆顶元素并添加该元素，如果比堆顶元素小，则什么也不做，继续下一个元素。时间复杂
 * 度 O(nlogk) ，空间复杂度 O(k) 。
 * 5. 利用快速排序中的partition思想，从数组中随机选择一个元素x，把数组划分为前后两部
 * 分 sa 和 sb ， sa 中的元素小于x， sb 中的元素大于或等于x。这时有两种情况：
 * i. sa 的元素个数小于 k ，则递归求解 sb 中的第 k-|sa| 大的元素
 * ii. sa 的元素个数大于或等于 k ，则递归求解 sa 中的第 k 大的元素
 * 时间复杂度 O(n) ，空间复杂度 O(1)
 * 思路4和5比较高效，可以接受，其他思路太慢了，不采纳
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/7/2 23:08
 */
@Slf4j
public class KthLargestElement {
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(
                4,
                4,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new MyHandler());


        ForkJoinPoolTest forkJoinPoolTest = new ForkJoinPoolTest();
        ForkJoinPoolTest.AddTask addTask = new ForkJoinPoolTest.AddTask(0, 5000);
        addTask.compute();

    }

    static class MyHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.info(Thread.currentThread().getName() + " " + " reject ");
            //save to redis or MQ
            //Try 3 times
            if (executor.getQueue().size() < 1000) {
                //put into queue
            }
        }
    }

    public static int kthLargestElement(int[] nums, int k) {
        final Queue<Integer> q = new PriorityQueue<>();

        for (int x : nums) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                final int top = q.peek();
                if (x > top) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }
}


class ForkJoinPoolTest {
    static int[] nums = new int[1000000];
    static final int MAX = 5000;
    static Random r = new Random();

    static {
        for (int i = 0; i < MAX; i++) {
            nums[i] = r.nextInt() * 100;
        }

        System.out.println(Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction {
        int start, end;

        AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < MAX) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("start : " + start + " end " + end + " sum = " + sum);
            } else {
                int middle = start + (end - start) >> 1;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }
}