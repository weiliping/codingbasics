#
# @lc app=leetcode.cn id=2919 lang=python3
#
# [2919] 使数组变美的最小增量运算数
#
# https://leetcode.cn/problems/minimum-increment-operations-to-make-array-beautiful/description/
#
# algorithms
# Medium (38.45%)
# Likes:    31
# Dislikes: 0
# Total Accepted:    3.9K
# Total Submissions: 10K
# Testcase Example:  '[2,3,0,0,2]\n4'
#
# 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和一个整数 k 。
#
# 你可以执行下述 递增 运算 任意 次（可以是 0 次）：
#
#
# 从范围 [0, n - 1] 中选择一个下标 i ，并将 nums[i] 的值加 1 。
#
#
# 如果数组中任何长度 大于或等于 3 的子数组，其 最大 元素都大于或等于 k ，则认为数组是一个 美丽数组 。
#
# 以整数形式返回使数组变为 美丽数组 需要执行的 最小 递增运算数。
#
# 子数组是数组中的一个连续 非空 元素序列。
#
#
#
# 示例 1：
#
#
# 输入：nums = [2,3,0,0,2], k = 4
# 输出：3
# 解释：可以执行下述递增运算，使 nums 变为美丽数组：
# 选择下标 i = 1 ，并且将 nums[1] 的值加 1 -> [2,4,0,0,2] 。
# 选择下标 i = 4 ，并且将 nums[4] 的值加 1 -> [2,4,0,0,3] 。
# 选择下标 i = 4 ，并且将 nums[4] 的值加 1 -> [2,4,0,0,4] 。
# 长度大于或等于 3 的子数组为 [2,4,0], [4,0,0], [0,0,4], [2,4,0,0], [4,0,0,4], [2,4,0,0,4]
# 。
# 在所有子数组中，最大元素都等于 k = 4 ，所以 nums 现在是美丽数组。
# 可以证明无法用少于 3 次递增运算使 nums 变为美丽数组。
# 因此，答案为 3 。
#
#
# 示例 2：
#
#
# 输入：nums = [0,1,3,3], k = 5
# 输出：2
# 解释：可以执行下述递增运算，使 nums 变为美丽数组：
# 选择下标 i = 2 ，并且将 nums[2] 的值加 1 -> [0,1,4,3] 。
# 选择下标 i = 2 ，并且将 nums[2] 的值加 1 -> [0,1,5,3] 。
# 长度大于或等于 3 的子数组为 [0,1,5]、[1,5,3]、[0,1,5,3] 。
# 在所有子数组中，最大元素都等于 k = 5 ，所以 nums 现在是美丽数组。
# 可以证明无法用少于 2 次递增运算使 nums 变为美丽数组。
# 因此，答案为 2 。
#
#
# 示例 3：
#
#
# 输入：nums = [1,1,2], k = 1
# 输出：0
# 解释：在这个示例中，只有一个长度大于或等于 3 的子数组 [1,1,2] 。
# 其最大元素 2 已经大于 k = 1 ，所以无需执行任何增量运算。
# 因此，答案为 0 。
#
#
#
#
# 提示：
#
#
# 3 <= n == nums.length <= 10^5
# 0 <= nums[i] <= 10^9
# 0 <= k <= 10^9
#
#
#

# @lc code=start
from typing import List


class Solution:
    def minIncrementOperations(self, nums: List[int], k: int) -> int:
        n = len(nums)
        res = [0 for _ in range(n)]
        for i in range(3):
            if k > nums[i]:
                res[i] = k - nums[i]
        for j in range(3, n):
            res[j] = min(res[j - 1], res[j - 2], res[j - 3])
            if k > nums[j]:
                res[j] += k - nums[j]
        return min(res[-1], res[-2], res[-3])

# @lc code=end
