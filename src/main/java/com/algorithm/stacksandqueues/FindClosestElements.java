package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestElements {
    /**
     * #658
     * https://leetcode-cn.com/problems/find-k-closest-elements/
     * @param args
     */
    public static void main(String[] args) {
        FindClosestElements closest = new FindClosestElements();
        System.out.println(Arrays.toString(closest.findClosestElements(new int[] {1,2,3,4,5}, 4, 3).toArray()));
        System.out.println(Arrays.toString(closest.findClosestElements(new int[] {1,2,3,4,5}, 4, -1).toArray()));
    }

    class Pair {
        int k;
        int v;
        public Pair(int key, int val) {
            k = key;
            v = val;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, (a, b) -> a.k == b.k ? b.v - a.v : b.k - a.k);

        for (int num : arr) {
            int key = Math.abs(num - x);
            if (queue.size() < k) {
                queue.offer(new Pair(key, num));
                continue;
            }
            if (key < queue.peek().k) {
                queue.poll();
                queue.offer(new Pair(key, num));
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().v);
        }
        Collections.sort(res);
        return res;
    }
}
