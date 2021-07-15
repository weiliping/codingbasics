package com.algorithm.arrays;

public class SearchMatrix {

    /**
     * #74
     * https://leetcode-cn.com/problems/search-a-2d-matrix
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(isInMatrix(matrix, 3));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int si = 0, ei = matrix.length;
        while (si < ei) {
            int mid = (si + ei) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        int row = (ei > 0) ? (ei - 1) : ei;

        si = 0;
        ei = matrix[row].length;

        while (si < ei) {
            int mid = (si + ei) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        return false;
    }

    static boolean isInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0;
        int c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    static boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return true;
        }

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return true;
    }
}
