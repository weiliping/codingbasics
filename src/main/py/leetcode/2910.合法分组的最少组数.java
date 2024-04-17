/*
 * @lc app=leetcode.cn id=2910 lang=java
 *
 * [2910] 合法分组的最少组数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int ball : balls) {
            mp.put(ball, mp.getOrDefault(ball, 0) + 1);
        }
        int minV = Integer.MAX_VALUE;
        for (Integer k : mp.keySet()) {
            minV = Math.min(minV, mp.get(k));
        }
        for(int i = minV; i > 0; i--) {
            int res = 0;
            for (Integer v : mp.values()) {
                if (v / i < v % i) {
                    res = 0;
                    break;
                }
                res += (v + i) / (i + 1);
            }
            if (res > 0) {
                return res;
            }
        }
        return 0;
    }
}
// @lc code=end

