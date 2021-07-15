package com.algorithm.kmerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInSortedList {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> r1 = new ArrayList<>();
        r1.add(5);
        r1.add(8);
        r1.add(9);
        matrix.add(r1);

        List<Integer> r2 = new ArrayList<>();
        r2.add(1);
        r2.add(7);
        matrix.add(r2);

        System.out.println(kthSmallest(matrix, 3));
    }

    public static int kthSmallest(List<List<Integer>> matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (List<Integer> subRes : matrix) {
            for (Integer num : subRes) {
                if (queue.size() < k) {
                    queue.offer(num);
                    continue;
                }

                if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
