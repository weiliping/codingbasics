package com.algorithm.selfpractice.round2;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
    public static int maxArea(int[] heights) {
        int s = 0, l = heights.length - 1, area = 0;
        while (s < l) {
            area = Math.max(area, Math.min(heights[s], heights[l]) * (l - s));
            if (heights[s] < heights[l]) {
                s++;
            } else {
                l--;
            }
        }
        return area;
    }
}
