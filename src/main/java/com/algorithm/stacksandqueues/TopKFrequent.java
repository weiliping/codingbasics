package com.algorithm.stacksandqueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * #347
     * https://leetcode-cn.com/problems/top-k-frequent-elements/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{2, 2, 1, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.v));
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(new Pair(m.getKey(), m.getValue()));
                continue;
            }
            if (m.getValue() > queue.peek().v) {
                queue.poll();
                queue.offer(new Pair(m.getKey(), m.getValue()));
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i++] = queue.poll().k;
        }
        return res;
    }
}
class Pair {
    int k;
    int v;

    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }
}