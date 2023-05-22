package com.algorithm.contest.weeklycontest330;

import java.util.PriorityQueue;

public class PutMarbles {
    public static void main(String[] args) {
        int[] weights1 = new int[] { 1, 3, 5, 1 };
        int k1 = 2;
        System.out.println(putMarbles(weights1, k1));
        int[] weights2 = new int[] { 1, 3 };
        int k2 = 2;
        System.out.println(putMarbles(weights2, k2));
    }

    public static long putMarbles(int[] weights, int k) {
        long res = 0l;
        if (k == 1) {
            return res;
        }
        int len = k - 1;
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(len);
        PriorityQueue<Integer> minQ = new PriorityQueue<>(len, (a, b) -> b - a);

        int n = weights.length;

        for (int i = 0; i < n - 1; i++) {
            int s = weights[i] + weights[i + 1];
            if (minQ.size() < len) {
                minQ.offer(s);
                maxQ.offer(s);
            } else {
                if (s < minQ.peek()) {
                    minQ.poll();
                    minQ.add(s);
                }
                if (s > maxQ.peek()) {
                    maxQ.poll();
                    maxQ.add(s);
                }
            }
        }

        while (!maxQ.isEmpty()) {
            res += maxQ.poll() - minQ.poll();
        }
        return res;
    }
}
