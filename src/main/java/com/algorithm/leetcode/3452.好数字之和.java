/*
 * @lc app=leetcode.cn id=3452 lang=java
 *
 * [3452] 好数字之和
 */

// @lc code=start
class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int s = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i - k < 0 && i + k >= n) {
                s += nums[i];
                continue;
            }
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                continue;
            }
            if (i + k < n && nums[i] <= nums[i + k]) {
                continue;
            }
            s += nums[i];
        }
        return s;     
    }
}
// @lc code=end

