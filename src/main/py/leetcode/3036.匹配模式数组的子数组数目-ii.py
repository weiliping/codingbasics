#
# @lc app=leetcode.cn id=3036 lang=python3
#
# [3036] 匹配模式数组的子数组数目 II
#
# https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-ii/description/
#
# algorithms
# Hard (48.52%)
# Likes:    9
# Dislikes: 0
# Total Accepted:    2.4K
# Total Submissions: 5K
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
# 2 <= n == nums.length <= 10^6
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

        def calc_prefix_len(pattern: List[int]) -> List[int]:
            n = len(pattern)
            ar = [0] * n
            ar[0] = 0
            pre_ind, i = 0, 1
            while i < n:
                if pattern[pre_ind] == pattern[i]:
                    pre_ind += 1
                    ar[i] = pre_ind
                    i += 1
                    continue
                if pre_ind != 0:
                    pre_ind = ar[pre_ind - 1]
                    continue
                i += 1
            return ar
        m, n = len(nums), len(pattern)
        num_arr = [0] * (m - 1)
        for i in range(m - 1):
            if nums[i + 1] > nums[i]:
                num_arr[i] = 1
                continue
            if nums[i + 1] == nums[i]:
                num_arr[i] = 0
                continue
            num_arr[i] = -1

        i, j, k = 0, 0, m - 1
        prefix_len = calc_prefix_len(pattern)

        cnt = 0
        while i < k:
            if num_arr[i] == pattern[j]:
                i += 1
                j += 1
                if j == n:
                    cnt += 1
                    j = prefix_len[j - 1]
                continue
            if j != 0:
                j = prefix_len[j - 1]
            else:
                i += 1
        return cnt
# @lc code=end

