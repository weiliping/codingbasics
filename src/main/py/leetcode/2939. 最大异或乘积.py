#
# @lc app=leetcode.cn id=2939 lang=python3
#
# [2939] 最大异或乘积
#
# https://leetcode.cn/problems/maximum-xor-product/
#
#
#
from typing import List
# @lc code=start

class Solution:
    MOD = 10**9 + 7
    def maximumXorProduct(self, a: int, b: int, n: int) -> int:
        aPrex, bPrex = ((a >> n) << n), ((b >> n) << n)
        res = [0]
        def dfs_helper(aa: int, bb: int, aPrex: int, bPrex: int, i: int, res: List[int]) -> None:
            if i == -1:
                res[0] = max(res[0], aPrex * bPrex)
                return
            ai = ((aa>>i) & 1)
            bj = ((bb>>i) & 1)
            v = 1 << i
            nxt = i - 1
            if ai == bj:
                dfs_helper(a, b, aPrex|v, bPrex|v, nxt, res)
            else:
                dfs_helper(a, b, aPrex|v, bPrex, nxt, res)
                dfs_helper(a, b, aPrex, bPrex|v, nxt, res)
        dfs_helper(a, b, aPrex, bPrex, n - 1, res)
        return res[0]%self.MOD
s = Solution()
print(s.maximumXorProduct(12, 5, 4))
# @lc code=end