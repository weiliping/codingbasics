package com.algorithm.arrays;

public class MaxArea {

    /**
     * #11
     * https://leetcode-cn.com/problems/container-with-most-water/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    public int maxArea(int[] height) {
        int s = 0, l = height.length - 1, area = 0;
        while (s < l) {
            area = Math.max(area, Math.min(height[s], height[l]) * (l - s));
            if (height[s] < height[l]) {
                s++;
            } else {
                l--;
            }
        }
        return area;
    }
}
