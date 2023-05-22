package com.algorithm.contest.weeklycontest253;

import java.util.PriorityQueue;

public class MinStoneSum {
    public static void main(String[] args) {
        MinStoneSum m = new MinStoneSum();
        System.out.println(m.minStoneSum(new int[] { 5, 4, 9 }, 2));
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int p : piles) {
            queue.offer(p);
            sum += p;
        }

        while (k > 0) {
            int v = queue.poll(), h = v / 2;
            sum -= h;
            queue.offer(v - h);
            k--;
        }
        return sum;
    }
}
