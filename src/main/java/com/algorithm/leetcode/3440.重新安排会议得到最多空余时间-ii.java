/*
 * @lc app=leetcode.cn id=3440 lang=java
 *
 * [3440] 重新安排会议得到最多空余时间 II
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        int res = startTime[0];
        preMax[0] = startTime[0];
        sufMax[n - 1] = eventTime - endTime[n - 1];
        res = Math.max(res, sufMax[n - 1]);
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(startTime[i] - endTime[i - 1], preMax[i - 1]);
            res = Math.max(res, preMax[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(startTime[i + 1] - endTime[i], sufMax[i + 1]);
        }

        int d = endTime[0] - startTime[0];
        res = Math.max(startTime[1] - d, res);
        if (sufMax[1] >= d) {
            res = Math.max(res, startTime[1]);
        }

        for (int i = 1; i < n - 1; i++) {
            d = endTime[i] - startTime[i];
            if (preMax[i - 1] >= d || sufMax[i + 1] >= d) {
                res = Math.max(res, startTime[i + 1] - endTime[i - 1]);
            }
            res = Math.max(res, startTime[i + 1] - endTime[i - 1] - d);
        }
        d = endTime[n - 1] - startTime[n - 1];
        res = Math.max(eventTime - endTime[n - 2] - d, res);
        if (preMax[n - 2] >= d) {
            res = Math.max(res, eventTime - endTime[n - 2]);
        }
        return res;
    }
}
// @lc code=end

