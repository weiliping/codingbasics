/*
 * @lc app=leetcode.cn id=2934 lang=java
 *
 * [2934] 最大化数组末位元素的最少操作次数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int d1 = 0;
        int d2 = 0;
        if (nums1[n - 1] > nums2[n - 1]) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] > nums1[n - 1] && nums2[i] > nums1[n - 1]) {
                return -1;
            }
            if (nums1[i] > nums2[n - 1] || nums2[i] > nums2[n - 1]) {
                return -1;
            }
            if (nums1[i] <= nums1[n - 1] && nums2[i] <= nums1[n - 1]) {
                continue;
            }
            if (nums1[i] > nums1[n - 1]) {
                d1 += 1;
            }
            if (nums2[i] > nums1[n - 1]) {
                d2 += 1;
            }
        }
        return Math.min(d2 + 1, d1);
    }
}
// @lc code=end

