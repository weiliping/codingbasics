package com.algorithm.design;

import java.util.PriorityQueue;

public class MedianFinder {

    /**
     * #295
     * https://leetcode-cn.com/problems/find-median-from-data-stream/
     *
     * @param args
     */
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(-small.poll());
        if (small.size() < large.size()) {
            small.offer(-large.poll());
        }
    }

    public double findMedian() {
        return small.size() > large.size() ? small.peek() : 0.5 * (small.peek() - large.peek());
    }
}
