package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class MaximalRectangle {

    /**
     * #85
     * https://leetcode-cn.com/problems/maximal-rectangle/
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] matrix = new char[][] { { '0', '1' } };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int r = matrix.length, c = matrix[0].length;
        int maxArea = 0;
        int[] leftLessMin = new int[c], rightLessMin = new int[c], heights = new int[c];
        Arrays.fill(leftLessMin, 0);
        Arrays.fill(rightLessMin, c);

        for (int row = 0; row < r; row++) {
            int leftboundary = 0, rightboundary = c;
            for (int col = 0; col < c; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                    leftLessMin[col] = Math.max(leftLessMin[col], leftboundary);
                } else {
                    heights[col] = 0;
                    leftLessMin[col] = 0;
                    leftboundary = col + 1;
                }
            }

            for (int col = c - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    rightLessMin[col] = Math.min(rightLessMin[col], rightboundary);
                } else {
                    rightLessMin[col] = c;
                    rightboundary = col;
                }
                int area = (rightLessMin[col] - leftLessMin[col]) * heights[col];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
