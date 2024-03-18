#
# @lc app=leetcode.cn id=3034 lang=python3
#
# [3034] 匹配模式数组的子数组数目 I
#
# https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-i/description/
#
# algorithms
# Medium (77.64%)
# Likes:    0
# Dislikes: 0
# Total Accepted:    2.6K
# Total Submissions: 3.4K
# Testcase Example:  '[1,2,3,4,5,6]\n[1,1]'
#
# 给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数
# -1 ，0 和 1 。
#
# 大小为 m + 1 的子数组 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组
# pattern ：
#
#
# 如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
# 如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
# 如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
#
#
# 请你返回匹配 pattern 的 nums 子数组的 数目 。
#
#
#
# 示例 1：
#
#
# 输入：nums = [1,2,3,4,5,6], pattern = [1,1]
# 输出：4
# 解释：模式 [1,1] 说明我们要找的子数组是长度为 3 且严格上升的。在数组 nums 中，子数组 [1,2,3] ，[2,3,4] ，[3,4,5]
# 和 [4,5,6] 都匹配这个模式。
# 所以 nums 中总共有 4 个子数组匹配这个模式。
#
#
# 示例 2：
#
#
# 输入：nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]
# 输出：2
# 解释：这里，模式数组 [1,0,-1] 说明我们需要找的子数组中，第一个元素小于第二个元素，第二个元素等于第三个元素，第三个元素大于第四个元素。在
# nums 中，子数组 [1,4,4,1] 和 [3,5,5,3] 都匹配这个模式。
# 所以 nums 中总共有 2 个子数组匹配这个模式。
#
#
#
#
# 提示：
#
#
# 2 <= n == nums.length <= 100
# 1 <= nums[i] <= 10^9
# 1 <= m == pattern.length < n
# -1 <= pattern[i] <= 1
#
#
#
from typing import List
# @lc code=start
class Solution:
    def countMatchingSubarrays(self, nums: List[int], pattern: List[int]) -> int:
        n, m = len(nums), len(pattern)
        cnt = 0
        for i in range(n - m):
            v = True
            for k in range(m):
                if pattern[k] == 1 and nums[i + k + 1] <= nums[i + k]:
                    v = False
                    break
                if pattern[k] == 0 and nums[i + k + 1] != nums[i + k]:
                    v = False
                    break
                if pattern[k] == -1 and nums[i + k + 1] >= nums[i + k]:
                    v = False
                    break
            if v:
                cnt += 1
        return cnt


# @lc code=end

