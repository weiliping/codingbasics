#
# @lc app=leetcode.cn id=2588 lang=python3
#
# [2588] 统计美丽子数组数目
#

# @lc code=start
from typing import List


class Solution:
    def beautifulSubarrays(self, nums: List[int]) -> int:
        pre, cnt = 0, 0
        dict = {pre: 1}
        for num in nums:
            pre ^= num
            if pre in dict:
                cnt += dict[pre]
                dict[pre] += 1
            else:
                dict[pre] = 1
        return cnt


# s = Solution()
# print(s.beautifulSubarrays([4, 3, 1, 2, 4]))
# print(s.beautifulSubarrays([1, 10, 4]))
# print(s.beautifulSubarrays([0, 1, 0]))
# @lc code=end
