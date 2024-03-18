#
# @lc app=leetcode.cn id=3040 lang=python3
#
# [3040] 相同分数的最大操作数目 II
#
# https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description/
#
# algorithms
# Medium (33.95%)
# Likes:    8
# Dislikes: 0
# Total Accepted:    2.5K
# Total Submissions: 7.2K
# Testcase Example:  '[3,2,1,2,3,4]'
#
# 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
#
#
# 选择 nums 中最前面两个元素并且删除它们。
# 选择 nums 中最后两个元素并且删除它们。
# 选择 nums 中第一个和最后一个元素并且删除它们。
#
#
# 一次操作的 分数 是被删除元素的和。
#
# 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
#
# 请你返回按照上述要求 最多 可以进行的操作次数。
#
#
#
# 示例 1：
#
#
# 输入：nums = [3,2,1,2,3,4]
# 输出：3
# 解释：我们执行以下操作：
# - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
# - 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
# - 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
# 由于 nums 为空，我们无法继续进行任何操作。
#
#
# 示例 2：
#
#
# 输入：nums = [3,2,6,1,4]
# 输出：2
# 解释：我们执行以下操作：
# - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
# - 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
# 至多进行 2 次操作。
#
#
#
#
# 提示：
#
#
# 2 <= nums.length <= 2000
# 1 <= nums[i] <= 1000
#
#
#
from typing import List
# @lc code=start
class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        def helper(i: int, j: int, v: int, nums: List[int], cnts: List[List[int]]) -> int:
            if i > j:
                return 0
            if cnts[i][j] != -1:
                return cnts[i][j]
            if i == j:
                cnts[i][j] = 0
                return cnts[i][j]
            if i + 1 == j:
                cnts[i][j] = 1 if nums[i] + nums[j] == v else 0
                return cnts[i][j]
            prev, middle, suff = 0, 0, 0
            if nums[i] + nums[i + 1] == v:
                prev = helper(i + 2, j, v, nums, cnts) + 1
            if nums[i] + nums[j] == v:
                middle = helper(i + 1, j - 1, v, nums, cnts) + 1
            if nums[j] + nums[j - 1] == v:
                suff = helper(i, j - 2, v, nums, cnts) + 1
            cnts[i][j] = max(prev, middle, suff)
            return cnts[i][j]
        n = len(nums)
        cnts1 = [[-1 for _ in range(n)] for _ in range(n)]
        cnts2 = [[-1 for _ in range(n)] for _ in range(n)]
        cnts3 = [[-1 for _ in range(n)] for _ in range(n)]
        maxV = helper(2, n - 1, nums[0] + nums[1], nums, cnts1) + 1
        maxV = max(maxV, helper(0, n - 3, nums[n - 1] + nums[n - 2], nums, cnts2) + 1)
        return max(maxV, helper(1, n - 2, nums[0] + nums[n - 1], nums, cnts3) + 1)
# nums = [1000] * 2000
nums = [3,2,1,4,1]
s = Solution()
print(s.maxOperations(nums))
# @lc code=end

