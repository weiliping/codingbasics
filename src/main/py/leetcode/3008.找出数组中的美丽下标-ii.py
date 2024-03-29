#
# @lc app=leetcode.cn id=3008 lang=python3
#
# [3008] 找出数组中的美丽下标 II
#
from typing import List
import bisect
# @lc code=start
class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        def hit_numbers(sb: str) -> List[int]:
            n = len(sb)
            hits = [0] * n
            i, j = 0, 1
            while j < n:
                if sb[i] == sb[j]:
                    i += 1
                    hits[j] = i
                    j += 1
                    continue
                if i != 0:
                    i = hits[i - 1]
                    continue
                j += 1
            return hits
        
        n, len_a, len_b = len(s), len(a), len(b)
        ind_a, ind_b = hit_numbers(a), hit_numbers(b)
        hits_ind_a, hits_ind_b = [], []
        i, j = 0, 0
        while i < n:
            if s[i] == a[j]:
                i += 1
                j += 1
                if j == len_a:
                    hits_ind_a.append(i - len_a)
                    j = ind_a[j - 1]
                continue
            if j != 0:
                j = ind_a[j - 1]
            else:
                i += 1
        i, j = 0, 0
        while i < n:
            if s[i] == b[j]:
                i += 1
                j += 1
                if j == len_b:
                    hits_ind_b.append(i - len_b)
                    j = ind_b[j - 1]
                continue
            if j != 0:
                j = ind_b[j - 1]
            else:
                i += 1
        res, m = [], len(hits_ind_b)
        for _, v in enumerate(hits_ind_a):
            ind1 = bisect.bisect_left(hits_ind_b, v - k)
            if ind1 < m and abs(v - hits_ind_b[ind1]) <= k:
                res.append(v)
                continue
            ind1 = bisect.bisect_right(hits_ind_b, v + k)
            if ind1 < m and abs(v - hits_ind_b[ind1]) <= k:
                res.append(v)
        return res
                
# @lc code=end

