#
# @lc app=leetcode.cn id=2592 lang=python3
#
# [2592] 最大化数组的伟大值
#

# @lc code=start

from typing import List


class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        nums.sort()
        i = 0
        for x in nums:
            if x > nums[i]:
                i += 1
        return i


# s = Solution()
# print(s.maximizeGreatness([1, 3, 5, 2, 1, 3, 1]))
# print(s.maximizeGreatness([1, 3, 5, 2, 3]))
# print(s.maximizeGreatness([1, 2, 3, 4]))

# @lc code=end
