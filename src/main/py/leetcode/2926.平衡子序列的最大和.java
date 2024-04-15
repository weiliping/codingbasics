/*
 * @lc app=leetcode.cn id=2926 lang=java
 *
 * [2926] 平衡子序列的最大和
 */

// @lc code=start

import java.util.TreeMap;

class Solution {
//     public static void main(String[] args) {
//         int[] nums = new int[] {-1,4,8,5,8,2,-8};
//         Solution2926 s = new Solution2926();
//         System.out.println(s.maxBalancedSubsequenceSum(nums));
//     }
    public long maxBalancedSubsequenceSum(int[] nums) {
        TreeMap<Integer, Long> dp = new TreeMap<>();
        int n = nums.length;
        Long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int k = nums[i] - i;
            Long v = Long.valueOf(nums[i]);
            if (dp.containsKey(k)) {
                v = Math.max(v, dp.get(k) + v);    
            } else {
                Integer pre = dp.lowerKey(k);   
                if (pre != null) {  
                    v = Math.max(v, dp.get(pre) + v);
                }
            }
            while(dp.higherKey(k) != null) {
                int h = dp.higherKey(k);
                if (dp.get(h) <= v) {
                    dp.remove(h);
                } else {
                    break;
                }
            }
            dp.put(k, v);
            res = Math.max(v, res);
        }
        return res;
    }
}
// @lc code=end

