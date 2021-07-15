package com.algorithm.twoheaps;

import java.util.PriorityQueue;

public class MaximizedCapital {

    public static void main(String[] args) {
        int k = 2, W = 0, profits[] = new int[] { 1, 2, 3 }, capital[] = { 0, 1, 1 };
        System.out.println(findMaximizedCapital(k, W, profits, capital));

    }
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] { Capital[i], Profits[i] });
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) {
                break;
            }

            W += pqPro.poll()[1];
        }

        return W;
    }
}
