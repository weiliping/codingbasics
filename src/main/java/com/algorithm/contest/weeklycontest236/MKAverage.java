package com.algorithm.contest.weeklycontest236;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/finding-mk-average/
 * #1825. 求出 MK 平均值
 *
 * 给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。
 *
 * MK 平均值 按照如下步骤计算：
 *
 * 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
 * 从这个容器中删除最小的 k 个数和最大的 k 个数。
 * 计算剩余元素的平均值，并 向下取整到最近的整数 。
 * 请你实现 MKAverage 类：
 *
 * MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
 * void addElement(int num) 往数据流中插入一个新的元素 num 。
 * int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。
 *  
 *
 * 示例 1：
 * 输入：
 * ["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
 * [[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
 * 输出：
 * [null, null, null, -1, null, 3, null, null, null, 5]
 *
 * 解释：
 * MKAverage obj = new MKAverage(3, 1);
 * obj.addElement(3);        // 当前元素为 [3]
 * obj.addElement(1);        // 当前元素为 [3,1]
 * obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
 * obj.addElement(10);       // 当前元素为 [3,1,10]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
 *                           // 删除最小以及最大的 1 个元素后，容器为 [3]
 *                           // [3] 的平均值等于 3/1 = 3 ，故返回 3
 * obj.addElement(5);        // 当前元素为 [3,1,10,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
 *                           // 删除最小以及最大的 1 个元素后，容器为 [5]
 *                           // [5] 的平均值等于 5/1 = 5 ，故返回 5
 *
 * 提示：
 * 3 <= m <= 105
 * 1 <= k*2 < m
 * 1 <= num <= 105
 * addElement 与 calculateMKAverage 总操作次数不超过 105 次。
 */
public class MKAverage {

    public static void main(String[] args) {
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(17612);
        mk.addElement(74607);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(8272);
        mk.addElement(33433);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(15456);
        mk.addElement(64938);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(99741);
    }

    static final int MOD = (int) 1e9 + 7;
    long sum;
    int m;
    int k;

    LinkedList<Integer> queue;
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> currMinQueue;
    PriorityQueue<Integer> currMaxQueue;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.sum = 0l;
        minQueue = new PriorityQueue<>((a, b) -> b - a);
        maxQueue = new PriorityQueue<>();
        currMinQueue = new PriorityQueue<>();
        currMaxQueue = new PriorityQueue<>((a, b) -> b - a);
        queue = new LinkedList<>();
    }

    public void addElement(int num) {
        queue.offer(num);
        if (!minQueue.isEmpty() && minQueue.peek() >= num) {
            minQueue.offer(num);
        } else if (!maxQueue.isEmpty() && maxQueue.peek() <= num) {
            maxQueue.offer(num);
        } else {
            currMinQueue.offer(num);
            currMaxQueue.offer(num);
            sum += num;
        }

        while (minQueue.size() > k) {
            int top = minQueue.poll();
            currMinQueue.offer(top);
            currMaxQueue.offer(top);
            sum += top;
        }
        while (maxQueue.size() > k) {
            int down = maxQueue.poll();
            currMinQueue.offer(down);
            currMaxQueue.offer(down);
            sum += down;
        }

        if (queue.size() > m) {
            int temp = queue.poll();
            if (minQueue.peek() >= temp) {
                minQueue.remove(temp);
            } else if (maxQueue.peek() <= temp) {
                maxQueue.remove(temp);
            } else {
                currMaxQueue.remove(temp);
                currMinQueue.remove(temp);
                sum -= temp;
            }
        }
        if (queue.size() >= m) {
            while (minQueue.size() < k) {
                int temp = currMinQueue.poll();
                currMaxQueue.remove(temp);
                sum -= temp;
                minQueue.offer(temp);
            }
            while (maxQueue.size() < k) {
                int temp = currMaxQueue.poll();
                currMinQueue.remove(temp);
                sum -= temp;
                maxQueue.offer(temp);
            }
        }
    }

    public int calculateMKAverage() {
        if (queue.size() < m) {
            return -1;
        }
        return (int) (sum / (m - 2 * k) % MOD);
    }
}
