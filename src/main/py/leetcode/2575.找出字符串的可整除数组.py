#
# @lc app=leetcode.cn id=2575 lang=python3
#
# [2575] 找出字符串的可整除数组
#

# @lc code=start
from typing import List


class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        res = []
        l = 0
        for i in range(len(word)):
            c = l * 10 + int(word[i])
            l = c % m
            v = 1 if l == 0 else 0
            res.insert(i, v)
        return res


# s = Solution()
# print(s.divisibilityArray("998244353", 3))
# print(s.divisibilityArray("1010", 10))
# @lc code=end
