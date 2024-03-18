#
# @lc app=leetcode.cn id=3026 lang=python3
#
# [3026] 最大好子数组和
#
# https://leetcode.cn/problems/maximum-good-subarray-sum/description/
#
# algorithms
# Medium (23.49%)
# Likes:    6
# Dislikes: 0
# Total Accepted:    2.5K
# Total Submissions: 10.3K
# Testcase Example:  '[1,2,3,4,5,6]\n1'
#
# 给你一个长度为 n 的数组 nums 和一个 正 整数 k 。
#
# 如果 nums 的一个子数组中，第一个元素和最后一个元素 差的绝对值恰好 为 k ，我们称这个子数组为 好 的。换句话说，如果子数组 nums[i..j]
# 满足 |nums[i] - nums[j]| == k ，那么它是一个好子数组。
#
# 请你返回 nums 中 好 子数组的 最大 和，如果没有好子数组，返回 0 。
#
#
#
# 示例 1：
#
#
# 输入：nums = [1,2,3,4,5,6], k = 1
# 输出：11
# 解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 1 。好子数组有 [1,2] ，[2,3] ，[3,4] ，[4,5] 和 [5,6]
# 。最大子数组和为 11 ，对应的子数组为 [5,6] 。
#
#
# 示例 2：
#
#
# 输入：nums = [-1,3,2,4,5], k = 3
# 输出：11
# 解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 3 。好子数组有 [-1,3,2] 和 [2,4,5] 。最大子数组和为 11
# ，对应的子数组为 [2,4,5] 。
#
#
# 示例 3：
#
#
# 输入：nums = [-1,-2,-3,-4], k = 2
# 输出：-6
# 解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 2 。好子数组有 [-1,-2,-3] 和 [-2,-3,-4] 。最大子数组和为 -6
# ，对应的子数组为 [-1,-2,-3] 。
#
#
#
#
# 提示：
#
#
# 2 <= nums.length <= 10^5
# -10^9 <= nums[i] <= 10^9
# 1 <= k <= 10^9
#
#
#
from typing import List
# @lc code=start
class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        MAX_V = -10**15
        n = len(nums)
        nums_s = [0] * (n + 1)
        for i in range(n):
            nums_s[i + 1] = nums[i] + nums_s[i]
        ans = MAX_V
        s = {}
        for i in range(n):
            if nums[i] in s.keys():
                ans = max(ans, (nums_s[i + 1] - s[nums[i]]))
            k1, k2 = nums[i] - k, nums[i] + k
            s[k1] = min(s.get(k1, nums_s[i]), nums_s[i])
            s[k2] = min(s.get(k2, nums_s[i]), nums_s[i])
        return 0 if ans == MAX_V else ans

# @lc code=end

