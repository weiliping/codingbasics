package com.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianSlidingWindow {

    /**
     * #480
     * https://leetcode-cn.com/problems/sliding-window-median
     * @param args
     */
    public static void main(String[] args) {
        int nums[] = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));

        int nums2[] = new int[] { 2147483647, 2147483647 }, k2 = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums2, k2)));

        int nums3[] =
                new int[] { -2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647,
                        2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648 }, k3 = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums3, k3)));

        int nums4[] =
                new int[] { -2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647,
                        2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648 }, k4 = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums4, k4)));

        int nums5[] = new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, k5 = 3;
        System.out.println(Arrays.toString(medianSlidingWindow(nums5, k5)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[0];
        }

        int n = nums.length;
        double[] res = new double[n - k + 1];
        PriorityQueue<Integer> right = new PriorityQueue<>();
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                removeNum(left, right, nums[i - k]);
            }
            addNum(left, right, nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian(left, right);
            }
        }
        return res;
    }

    private static void removeNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if (num > getMedian(left, right)) {
            right.remove(num);
        } else {
            left.remove(num);
        }
        balanceQueues(left, right);
    }

    private static void addNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if (num > getMedian(left, right)) {
            right.offer(num);
        } else {
            left.offer(num);
        }
        balanceQueues(left, right);
    }

    private static void balanceQueues(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() < right.size()) {
            left.offer(right.poll());
        } else if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.isEmpty() && right.isEmpty()) {
            return 0.0;
        }
        if (left.size() == right.size()) {
            return ((double) left.peek() + (double) right.peek()) * 0.5;
        }
        return (double) left.peek();
    }
}
