#
# @lc app=leetcode.cn id=2576 lang=python3
#
# [2576] 求出最多标记下标
#

# @lc code=start
from typing import List


class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        cnt, n = 0, len(nums)
        i = n - 1
        half = n >> 1
        for j in range(half - 1, -1, -1):
            if nums[j] << 1 <= nums[i]:
                cnt += 2
                i -= 1
        return cnt


# s = Solution()
# print(s.maxNumOfMarkedIndices([42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40]
        #   ))
# @lc code=end
