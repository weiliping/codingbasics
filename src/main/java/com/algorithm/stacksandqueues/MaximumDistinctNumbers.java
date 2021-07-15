package com.algorithm.stacksandqueues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctNumbers {

    public static void main(String[] args) {
        System.out.println(maximumDistinctNum(new int[] {7, 3, 5, 8, 5, 3, 3}, 2));
        System.out.println(maximumDistinctNum(new int[] {3, 5, 12, 11, 12}, 3));
    }

    public static int maximumDistinctNum(int[] nums, int k) {
        HashSet<Integer> distNums = new HashSet<>();
        HashMap<Integer, Integer> dupNums = new HashMap<>();

        for (int num : nums) {
            if (!distNums.contains(num)) {
                distNums.add(num);
                continue;
            }
            dupNums.put(num, dupNums.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (Map.Entry<Integer, Integer> m : dupNums.entrySet()) {
            queue.offer(new int[] {m.getKey(), m.getValue()});
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] e = queue.peek();
            if (k >= e[1]) {
                queue.poll();
            }
            k -= e[1];
        }

        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            if (distNums.contains(e[0])) {
                distNums.remove(e[0]);
            }
        }
        return distNums.size() - k;
    }
}
