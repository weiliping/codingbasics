package com.algorithm.stacksandqueues;

import java.util.Stack;

public class LargestRectangleArea {
    /**
     * #84
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        LargestRectangleArea t = new LargestRectangleArea();
        System.out.println(t.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int res = 0;
        Stack<Integer> s = new Stack<>();
        int len = heights.length;
        for (int i = 0; i < len + 1; ++i) {
            int currVal = i < len ? heights[i] : 0;
            if (s.isEmpty() || currVal > heights[s.peek()]) {
                s.push(i);
            } else {
                int t = s.pop();
                res = Math.max(res, heights[t] * (s.isEmpty() ? i : (i - s.peek() - 1)));
                --i;
            }
        }
        return res;
    }
}
