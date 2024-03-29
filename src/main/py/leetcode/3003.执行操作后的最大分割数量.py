#
# @lc app=leetcode.cn id=3003 lang=python3
#
# [3003] 执行操作后的最大分割数量
#
from functools import cache
from typing import List
# @lc code=start
class Solution:
    def maxPartitionsAfterOperations(self, s: str, k: int) -> int:
        @cache
        def dfs(i: int, n: int, mask: int, changed: bool) -> int:
            if i == n:
                return 1
            
            bit = 1 << (ord(s[i]) - ord('a'))
            n_mask = mask | bit
            if n_mask.bit_count() > k:
                res = dfs(i + 1, n, bit, changed) + 1
            else:
                res = dfs(i + 1, n, n_mask, changed)
            if changed:
                return res
            
            for j in range(26):
                n_mask = mask | 1 << j
                if n_mask.bit_count() > k:
                    res = max(res, dfs(i + 1, n, 1 << j, True) + 1)
                else:
                    res = max(res, dfs(i + 1, n, n_mask, True))
            return res
        return dfs(0, len(s), 0, False)
# @lc code=end

