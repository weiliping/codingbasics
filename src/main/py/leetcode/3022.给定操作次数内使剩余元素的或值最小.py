#
# @lc app=leetcode.cn id=3022 lang=python3
#
# [3022] 给定操作次数内使剩余元素的或值最小
#
# https://leetcode.cn/problems/minimize-or-of-remaining-elements-using-operations/description/
#
# algorithms
# Hard (52.03%)
# Likes:    20
# Dislikes: 0
# Total Accepted:    1.3K
# Total Submissions: 2.5K
# Testcase Example:  '[3,5,3,2,7]\n2'
#
# 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
#
# 一次操作中，你可以选择 nums 中满足 0 <= i < nums.length - 1 的一个下标 i ，并将 nums[i] 和 nums[i +
# 1] 替换为数字 nums[i] & nums[i + 1] ，其中 & 表示按位 AND 操作。
#
# 请你返回 至多 k 次操作以内，使 nums 中所有剩余元素按位 OR 结果的 最小值 。
#
#
#
# 示例 1：
#
#
# 输入：nums = [3,5,3,2,7], k = 2
# 输出：3
# 解释：执行以下操作：
# 1. 将 nums[0] 和 nums[1] 替换为 (nums[0] & nums[1]) ，得到 nums 为 [1,3,2,7] 。
# 2. 将 nums[2] 和 nums[3] 替换为 (nums[2] & nums[3]) ，得到 nums 为 [1,3,2] 。
# 最终数组的按位或值为 3 。
# 3 是 k 次操作以内，可以得到的剩余元素的最小按位或值。
#
# 示例 2：
#
#
# 输入：nums = [7,3,15,14,2,8], k = 4
# 输出：2
# 解释：执行以下操作：
# 1. 将 nums[0] 和 nums[1] 替换为 (nums[0] & nums[1]) ，得到 nums 为 [3,15,14,2,8] 。
# 2. 将 nums[0] 和 nums[1] 替换为 (nums[0] & nums[1]) ，得到 nums 为 [3,14,2,8] 。
# 3. 将 nums[0] 和 nums[1] 替换为 (nums[0] & nums[1]) ，得到 nums 为 [2,2,8] 。
# 4. 将 nums[1] 和 nums[2] 替换为 (nums[1] & nums[2]) ，得到 nums 为 [2,0] 。
# 最终数组的按位或值为 2 。
# 2 是 k 次操作以内，可以得到的剩余元素的最小按位或值。
#
#
# 示例 3：
#
#
# 输入：nums = [10,7,10,3,9,14,9,4], k = 1
# 输出：15
# 解释：不执行任何操作，nums 的按位或值为 15 。
# 15 是 k 次操作以内，可以得到的剩余元素的最小按位或值。
#
#
#
#
# 提示：
#
#
# 1 <= nums.length <= 10^5
# 0 <= nums[i] < 2^30
# 0 <= k < nums.length
#
#
#
from typing import List
# @lc code=start
class Solution:
    def minOrAfterOperations(self, nums: List[int], k: int) -> int:
        INI_V = 2 ** 30 - 1
        ans, mask = 0, 0
        for i in range(29, -1, -1):
            cnt, cur = 0, INI_V
            mask |= (1 << i)
            for _, v in enumerate(nums):
                cur &= v & mask
                if cur > 0:
                    cnt += 1
                    continue
                cur = INI_V
            if cnt > k:
                mask ^= (1 << i)
                ans |= (1 << i)
        return ans
# @lc code=end

