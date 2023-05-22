#
# @lc app=leetcode.cn id=1493 lang=python3
#
# [1493] 删掉一个元素以后全为 1 的最长子数组
#
# https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
#
# algorithms
# Medium (58.98%)
# Likes:    75
# Dislikes: 0
# Total Accepted:    16.6K
# Total Submissions: 28K
# Testcase Example:  '[1,1,0,1]'
#
# 给你一个二进制数组 nums ，你需要从中删掉一个元素。
#
# 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
#
# 如果不存在这样的子数组，请返回 0 。
#
#
#
# 提示 1：
#
#
# 输入：nums = [1,1,0,1]
# 输出：3
# 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
#
# 示例 2：
#
#
# 输入：nums = [0,1,1,1,0,1,1,0,1]
# 输出：5
# 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
#
# 示例 3：
#
#
# 输入：nums = [1,1,1]
# 输出：2
# 解释：你必须要删除一个元素。
#
#
#
# 提示：
#
#
# 1 <= nums.length <= 10^5
# nums[i] 要么是 0 要么是 1 。
#
#
#

# @lc code=start
from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        i, n = 0, len(nums)
        dp = [0] * (n + 1)
        cnt = 0
        while i < n:
            if nums[i] == 0:
                i += 1
            else:
                j = i + 1
                while j < n and nums[j] == 1:
                    j += 1
                dp[j] = j - i
                if i == 0 and j == n:
                    dp[j] -= 1
                sub = dp[j] + dp[i - 1] if i > 0 else dp[j]
                if cnt < sub:
                    cnt = sub
                i = j
        return cnt


# s = Solution()
# print(s.longestSubarray([1, 1, 0, 1]))  # 3
# print(s.longestSubarray([0, 1, 1, 1, 0, 1, 1, 0, 1]))  # 5
# print(s.longestSubarray([1, 1, 1]))  # 2
# print(s.longestSubarray([1, 0, 0]))  # 1
# print(s.longestSubarray([0, 1, 1, 1, 1]))  # 4
# @lc code=end
