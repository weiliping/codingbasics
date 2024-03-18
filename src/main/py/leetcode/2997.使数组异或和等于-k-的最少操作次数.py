#
# @lc app=leetcode.cn id=2997 lang=python3
#
# [2997] 使数组异或和等于 K 的最少操作次数
#
from typing import List
# @lc code=start
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        s = nums[0]
        for i in range(1, len(nums)):
            s ^= nums[i]
        def to_bin(num: int) -> int:
            bin_num = [0] * 20
            for i in range(20):
                if ((num >> i) & 1) == 1:
                    bin_num[i] = 1
                    continue
            return bin_num
        
        a, b = to_bin(s), to_bin(k)
        cnt = 0
        for i in range(20):
            if a[i] != b[i]:
                cnt += 1
        return cnt
# @lc code=end

