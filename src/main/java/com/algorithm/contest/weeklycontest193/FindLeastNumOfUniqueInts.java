package com.algorithm.contest.weeklycontest193;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        FindLeastNumOfUniqueInts f = new FindLeastNumOfUniqueInts();
        System.out.println(f.findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
        System.out.println(f.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        int n = arr.length;
        for (int num : arr) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(n, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        for (Map.Entry<Integer, Integer> m : cnts.entrySet()) {
            queue.offer(new int[]{m.getKey(), m.getValue()});
        }

        while (k > 0) {
            int[] t = queue.poll();
            if (k < t[1]) {
                queue.offer(new int[] {t[0], t[1] - k});
            }
            k -= t[1];
        }
        return queue.size();
    }
}
