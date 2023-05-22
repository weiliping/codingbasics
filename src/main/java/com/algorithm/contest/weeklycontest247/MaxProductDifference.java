package com.algorithm.contest.weeklycontest247;

import java.util.PriorityQueue;

public class MaxProductDifference {
    public static void main(String[] args) {
        MaxProductDifference m = new MaxProductDifference();
        System.out.println(m.maxProductDifference(new int[] {5,6,2,7,4}));
        System.out.println(m.maxProductDifference(new int[] {4,2,5,9,7,4,8}));
    }
    public int maxProductDifferenceI(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        for (int num : nums) {
            if (a < num || b < num) {
                if (a < num) {
                    if (b < a) {
                        b = a;
                    }
                    a = num;
                } else {
                    b = num;
                }
            }
            if (c > num || d > num) {
                if (c > num) {
                    if (d > c) {
                        d = c;
                    }
                    c = num;
                    continue;
                }
                d = num;
            }
        }
        return (a * b) - (c * d);
    }

    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> minNums = new PriorityQueue<>(2, (a, b) -> b - a);
        PriorityQueue<Integer> maxNums = new PriorityQueue<>(2);
        for (int num : nums) {
            if (maxNums.size() < 2) {
                maxNums.offer(num);
                minNums.offer(num);
                continue;
            }
            if (num > maxNums.peek()) {
                maxNums.poll();
                maxNums.offer(num);
            }
            if (num < minNums.peek()) {
                minNums.poll();
                minNums.offer(num);
            }
        }
        return (maxNums.poll() * maxNums.poll()) - (minNums.poll() * minNums.poll());
    }
}
