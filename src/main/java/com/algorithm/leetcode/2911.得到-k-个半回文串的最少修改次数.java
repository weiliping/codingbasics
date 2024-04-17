/*
 * @lc app=leetcode.cn id=2911 lang=java
 *
 * [2911] 得到 K 个半回文串的最少修改次数
 */

// @lc code=start
class Solution {
    static final int M = 201;
    public int minimumChanges(String s, int k) {
        int[][] dp = new int[M][M];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dp[i][i] = M;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = minChange(i, j, s);
            }
        }
        int[][] res = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], -1);
        }
        return dfs(0, k - 1, dp, n, res);
    }

    private static int dfs(int s, int k, int[][] dp, int n, int[][] res) {
        if (res[s][k] != -1) {
            return res[s][k];
        }
        if (k == 0) {
            res[s][k] = dp[s][n - 1];
            return res[s][k];
        }
        int cnt = M;
        for (int i = s + 1; i < n - 2; i++) {
            cnt = Math.min(cnt, dp[s][i] + dfs(i + 1, k - 1, dp, n, res));
        }
        res[s][k] = cnt;
        return res[s][k];
    }

    private int minChange(int i, int j, String s) {
        int len = j - i + 1;
        int d = 1;
        int h = (len >> 1) + 1;
        int maxV = M;
        while (d < h) {
            if (len % d != 0) {
                d += 1;
                continue;
            }
            int cnt = 0;
            for (int sInd = 0; sInd < d; sInd++) {
                int sI = 0, sJ = (len / d) - 1;
                while (sI <= sJ) {
                    if (s.charAt(i + sI * d + sInd) != s.charAt(i + sJ * d + sInd)) {
                        cnt += 1;
                    }
                    sI += 1;
                    sJ -= 1;
                }
            }
            maxV = Math.min(maxV, cnt);
            d += 1;
        }
        return maxV;
    }
}
// @lc code=end

