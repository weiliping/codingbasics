/*
 * @lc app=leetcode.cn id=3446 lang=java
 *
 * [3446] 按对角线进行矩阵排序
 */

// @lc code=start

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // left-down part
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n - i];
            int j = 0;
            for (int k = 0; k < n - i; k++) {
                int num = grid[i+k][j+k];
                int l = k;
                while (l > 0 && temp[l-1] < num) {
                    temp[l] = temp[l-1];
                    l--;
                }
                temp[l] = num;
            }
            
            for (int k = 0; k < n - i; k++) {
                grid[i+k][j+k] = temp[k];
            }
        }

        // right-up part
        for (int j = 1; j < n; j++) {
            int[] temp = new int[n - j];
            int i = 0;
            for (int k = 0; k < n - j; k++) {
                int num = grid[i+k][j+k];
                int l = k;
                while (l > 0 && temp[l-1] > num) {
                    temp[l] = temp[l-1];
                    l--;
                }
                temp[l] = num;
            }
            for (int k = 0; k < n - j; k++) {
                grid[i+k][j+k] = temp[k];
            }
        }
        return grid;
    }
}
// @lc code=end

