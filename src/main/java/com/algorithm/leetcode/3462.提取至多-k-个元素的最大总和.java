/*
 * @lc app=leetcode.cn id=3462 lang=java
 *
 * [3462] 提取至多 K 个元素的最大总和
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        if (k == 0) {
            return 0l;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            Arrays.sort(row);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > n - limits[i] - 1; j--) {
                if (pq.size() < k) {
                    pq.offer(grid[i][j]);
                } else if (grid[i][j] > pq.peek()) {
                    pq.poll();
                    pq.offer(grid[i][j]);
                }
            }
        }
        long s = 0;
        while (pq.size() > 0) {
            s += pq.poll();
        }
        return s;
    }
}
// @lc code=end

