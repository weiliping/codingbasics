package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2850 lang=java
 *
 * [2850] 将石头分散到网格图的最少移动次数
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution2850 {
    public static void main(String[] args) {
        Solution2850 s = new Solution2850();
        // System.out.println(s.minimumMoves(new int[][]{{1,3,0},{1,0,0},{1,0,3}}));
        System.out.println(s.minimumMoves(new int[][]{{3,2,0},{0,1,0},{0,3,0}}));// 7
    }
    public int minimumMoves(int[][] grid) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        Queue<boolean[][]> q1 = new LinkedList<boolean[][]>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {  
                    boolean[][] visited = new boolean[3][3];
                    q.add(new int[]{i, j, i, j, 0});
                    visited[i][j] = true;
                    q1.add(visited);
                }
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            boolean[][] visited = q1.poll();
            int i = p[2], j = p[3], v = p[4];
            if (i > 0) {
                int il = i - 1;
                if (!visited[il][j]) {
                    visited[il][j] = true;
                    if (grid[il][j] == 0) {
                        if (grid[p[0]][p[1]] > 1) {
                            grid[p[0]][p[1]] -= 1;
                            grid[il][j] = 1;
                            ans += v + 1;
                            if (grid[p[0]][p[1]] == 1) {
                                continue;
                            } 
                        }
                    }
                    if (grid[p[0]][p[1]] > 1) {
                        q.add(new int[]{p[0], p[1], il, j, v + 1});
                        q1.add(visited);
                    }
                }
            }
            if (i < 2) {
                int ir = i + 1;
                if (!visited[ir][j]) {
                    visited[ir][j] = true;
                    if (grid[ir][j] == 0) {
                        if (grid[p[0]][p[1]] > 1) {
                            grid[p[0]][p[1]] -= 1;
                            grid[ir][j] = 1;
                            ans += v + 1;
                            if (grid[p[0]][p[1]] == 1) {
                                continue;
                            } 
                        }
                    }
                    if (grid[p[0]][p[1]] > 1) {
                        q.add(new int[]{p[0], p[1], ir, j, v + 1});
                        q1.add(visited);
                    }
                }
            }
            if (j > 0) {
                int ju = j - 1;
                if (!visited[i][ju]) {
                    visited[i][ju] = true;
                    if (grid[i][ju] == 0) {
                        if (grid[p[0]][p[1]] > 1) {
                            grid[p[0]][p[1]] -= 1;
                            grid[i][ju] = 1;
                            ans += v + 1;
                            if (grid[p[0]][p[1]] == 1) {
                                continue;
                            } 
                        }
                    }
                    if (grid[p[0]][p[1]] > 1) {
                        q.add(new int[]{p[0], p[1], i, ju, v + 1});
                        q1.add(visited);
                    }
                }
            }
            if (j < 2) {
                int jd = j + 1;
                if (!visited[i][jd]) {
                    visited[i][jd] = true;
                    if (grid[i][jd] == 0) {
                        if (grid[p[0]][p[1]] > 1) {
                            grid[p[0]][p[1]] -= 1;
                            grid[i][jd] = 1;
                            ans += v + 1;
                            if (grid[p[0]][p[1]] == 1) {
                                continue;
                            } 
                        }
                    }
                    if (grid[p[0]][p[1]] > 1) {
                        q.add(new int[]{p[0], p[1], i, jd, v + 1});
                        q1.add(visited);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

