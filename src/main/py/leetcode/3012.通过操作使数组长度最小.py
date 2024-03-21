#
# @lc app=leetcode.cn id=3012 lang=python3
#
# [3012] 通过操作使数组长度最小
#

from typing import List
import math
# @lc code=start
class Solution:
    def minimumArrayLength(self, nums: List[int]) -> int:
        min_v = min(nums)
        for _, v in enumerate(nums):          
            if v % min_v != 0:
                return 1
        return math.ceil(nums.count(min_v)/2)
# @lc code=end

