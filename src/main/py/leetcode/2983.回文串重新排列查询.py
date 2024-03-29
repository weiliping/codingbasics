#
# @lc app=leetcode.cn id=2983 lang=python3
#
# [2983] 回文串重新排列查询
#
from typing import List
# @lc code=start
class Solution:
    def canMakePalindromeQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        n2 = len(s)
        n, m_ind2 = n2 >> 1, n2 - 1
        CHR_INT = ord('a')
        pre_sum_bools = [0]
        for i in range(n):
            cur = pre_sum_bools[-1]
            if s[i] != s[m_ind2 - i]:
                cur += 1
            pre_sum_bools.append(cur)
        pre_cnts = [[0]*26]
        for i in range(n2):
            cur = pre_cnts[-1].copy()
            ind = ord(s[i]) - CHR_INT
            cur[ind] += 1
            pre_cnts.append(cur)
        def is_valid_range(pre_cnts: List[List[int]], a: int, b: int, m_ind: int) -> bool:
            x1, y1 = pre_cnts[a], pre_cnts[b + 1]
            x2, y2 = pre_cnts[m_ind - b], pre_cnts[m_ind - a + 1]
            for i in range(26):
                if y1[i] - x1[i] != y2[i] - x2[i]:
                    return False
            return True
        def is_valid(q: List[int], pre_sum_bools: List[List[int]], pre_cnts: List[List[int]], n: int) -> bool:
            a, b, rx1, ry1 = q
            n2 = n << 1
            m_ind = n2 - 1
            c, d = m_ind - ry1, m_ind - rx1
            # first 0, ly0
            if b < c or d < a:
                if d < a:
                    a, c = c, a
                    b, d = d, b
                if a > 0 and pre_sum_bools[a] > 0:
                    return False
                if not is_valid_range(pre_cnts, a, b, m_ind):
                    return False
                if b + 1 <= c - 1 and pre_sum_bools[c] - pre_sum_bools[b + 1] > 0:
                    return False
                if not is_valid_range(pre_cnts, c, d, m_ind):
                    return False
                if d + 1 < n and pre_sum_bools[n] - pre_sum_bools[d+1] > 0:
                    return False
            elif (a <= c and d <= b) or (c <= a and b <= d):
                x = min(a, c)
                y = max(b, d)
                if x - 1 >= 0 and pre_sum_bools[x] > 0:
                    return False
                if not is_valid_range(pre_cnts, x, y, m_ind):
                    return False
                if y + 1 < n and pre_sum_bools[n] - pre_sum_bools[y+1] > 0:
                    return False
            else:
                if b < d and b >= c:
                    if a > 0 and pre_sum_bools[a] > 0:
                        return False
                    x1 = pre_cnts[a]
                    y1 = pre_cnts[b + 1]
                    x2 = pre_cnts[m_ind - c + 1]
                    y2 = pre_cnts[m_ind - a + 1]
                    l_c_cnts = [0] * 26
                    for i in range(26):
                        c_v = y2[i] - x2[i]
                        if y1[i] - x1[i] < c_v:
                            return False
                        else:
                            l_c_cnts[i] = x1[i] + c_v
                    x3 = pre_cnts[b + 1]
                    y3 = pre_cnts[d + 1]
                    x4 = pre_cnts[m_ind - d]
                    y4 = pre_cnts[m_ind - c + 1]
                    r_c_cnts = [0] * 26
                    for i in range(26):
                        c_v = y3[i] - x3[i]
                        if y4[i] - x4[i] < c_v:
                            return False
                        else:
                            r_c_cnts[i] = x4[i] + c_v
                    for i in range(26):
                        if y1[i] - l_c_cnts[i] != y4[i] - r_c_cnts[i]:
                            return False
                    if d + 1 < n and pre_sum_bools[n] - pre_sum_bools[d+1] > 0:
                        return False
                else:
                    if c > 0 and pre_sum_bools[c] > 0:
                        return False
                    x1 = pre_cnts[c]
                    y1 = pre_cnts[a]
                    x2 = pre_cnts[m_ind - d]
                    y2 = pre_cnts[m_ind - c + 1]
                    l_c_cnts = [0] * 26
                    for i in range(26):
                        c_v = y1[i] - x1[i]
                        if y2[i] - x2[i] < c_v:
                            return False
                        else:
                            l_c_cnts[i] = x2[i] + c_v
                    x3 = pre_cnts[a]
                    y3 = pre_cnts[b + 1]
                    x4 = pre_cnts[m_ind - b]
                    y4 = pre_cnts[m_ind - d]
                    r_c_cnts = [0] * 26
                    for i in range(26):
                        c_v = y4[i] - x4[i]
                        if y3[i] - x3[i] < c_v:
                            return False
                        else:
                            r_c_cnts[i] = x3[i] + c_v
                    for i in range(26):
                        if y2[i] - l_c_cnts[i] != y3[i] - r_c_cnts[i]:
                            return False
                    if b + 1 < n and pre_sum_bools[n] - pre_sum_bools[b+1] > 0:
                        return False
            return True

        res = []
        for q in queries:
            res.append(is_valid(q, pre_sum_bools, pre_cnts, n))
        return res
# @lc code=end

