package com.algorithm.contest.weeklycontest331;

import java.util.PriorityQueue;

public class PickGifts {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[] { 54, 6, 34, 66, 63, 52, 39, 62, 46, 75, 28, 65, 18, 37, 18, 13, 33, 69,
                19, 40, 13, 10, 43, 61, 72 }, 7));
    }

    public static long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int g : gifts) {
            queue.offer(g);
        }
        while (k > 0) {
            Double d = Math.sqrt(queue.poll());
            queue.offer(Integer.valueOf(d.intValue()));
            k--;
        }

        long r = 0l;
        while (!queue.isEmpty()) {
            r += queue.poll();
        }

        return r;
    }
}
