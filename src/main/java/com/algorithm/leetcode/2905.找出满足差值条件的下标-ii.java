/*
 * @lc app=leetcode.cn id=2905 lang=java
 *
 * [2905] 找出满足差值条件的下标 II
 */

// @lc code=start
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int maxI = 0, minI = 0;
        for (int j = indexDifference; j < n; j++) {
            int i = j - indexDifference;
            if (nums[maxI] < nums[i]) {
                maxI = i;
            }
            if (nums[minI] > nums[i]) {
                minI = i;
            }
            if (Math.abs(nums[maxI] - nums[j]) >= valueDifference) {
                return new int[] {maxI, j};
            }
            if (Math.abs(nums[j] - nums[minI]) >= valueDifference) {
                return new int[] {minI, j};
            } 
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end

