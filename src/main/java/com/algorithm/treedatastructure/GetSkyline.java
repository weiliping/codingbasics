package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetSkyline {

    /**
     * #218
     * https://leetcode-cn.com/problems/the-skyline-problem
     * @param args
     */
    public static void main(String[] args) {
        int[][] buildings = new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        List<List<Integer>> res = new GetSkyline().getSkyline(buildings);
        printList(res);

        int[][] buildings1 = new int[][] { { 0,2147483647,2147483647 }};
        List<List<Integer>> res1 = new GetSkyline().getSkyline(buildings1);
        printList(res1);
    }

    static void printList(List<List<Integer>> res) {
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[] { b[0], -b[2] });
            height.add(new int[] { b[1], b[2] });
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                List<Integer> sub = new ArrayList<>();
                sub.add(h[0]);
                sub.add(cur);
                result.add(sub);
                prev = cur;
            }
        }
        return result;
    }
}
