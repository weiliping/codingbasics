/*
 * @lc app=leetcode.cn id=2970 lang=java
 *
 * [2970] 统计移除递增子数组的数目 I
 */

// @lc code=start
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return ((n * (n + 1)) >> 1);
        }
        int res = i + 2;
        for (int j = n - 1; j == n - 1 || nums[j + 1] > nums[j]; j--) {
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
            }
            res += i + 2;
        }
        return res;
    }
}
// @lc code=end

