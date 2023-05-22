package com.algorithm.binarysearch;

public class SearchMatrix {

    /**
     * #240
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrixI(matrix, 5));
        System.out.println(searchMatrixII(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrixI(matrix, 20));
        System.out.println(searchMatrixII(matrix, 20));
    }

    public static boolean searchMatrixI(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        return binarySearchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private static boolean binarySearchMatrix(int[][] matrix, int target, int rL, int rR, int cL, int cR) {
        if (rL > rR || cL > cR) {
            return false;
        }

        int x = (rL + rR) / 2, y = (cL + cR) / 2;
        int num = matrix[x][y];

        if (num == target) {
            return true;
        }

        if (num > target) {
            return binarySearchMatrix(matrix, target, rL, x - 1, cL, cR) ||
                    binarySearchMatrix(matrix, target, rL, rR, cL, y - 1);
        }
        return binarySearchMatrix(matrix, target, x + 1, rR, cL, cR) ||
                binarySearchMatrix(matrix, target, rL, rR, y + 1, cR);
    }

    public static boolean searchMatrixII(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                j--;
                continue;
            }
            i++;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (binarySearch(nums, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
