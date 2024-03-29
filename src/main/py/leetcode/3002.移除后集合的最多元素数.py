#
# @lc app=leetcode.cn id=3002 lang=python3
#
# [3002] 移除后集合的最多元素数
#
from typing import List
# @lc code=start
class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        s1, s2 = set(nums1), set(nums2)
        
        cnt, c_cnt1 = 0, 0
        h1 = (len(nums1) >> 1)
        h2 = h1
        for v in s1:
            if v not in s2:
                if h1 > 0:
                    h1 -= 1
                    cnt += 1
            else:
                c_cnt1 += 1

        for v in s2:
            if v not in s1:
                h2 -= 1
                cnt += 1
                if h2 == 0:
                    break
        return cnt + min(c_cnt1, h1 + h2)
    
# @lc code=end

