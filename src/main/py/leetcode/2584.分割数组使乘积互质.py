#
# @lc app=leetcode.cn id=2584 lang=python3
#
# [2584] 分割数组使乘积互质
#

# @lc code=start
from typing import List


class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return -1

        def primeFactorization(num) -> set:
            up = int(num**0.5 + 1)
            ans = []
            for i in range(2, up):
                while num % i == 0:
                    num /= i
                    ans += [i]
            if num != 1:
                ans += [int(num)]
            return set(ans)
        pre = primeFactorization(nums[0])
        i = 0

        while i < n:
            left = pre
            j = i + 1
            hasDuplicate = False
            while j < n:
                right = primeFactorization(nums[j])
                pre = pre.union(right)
                if left & right:
                    hasDuplicate = True
                    break
                else:
                    j += 1
            if hasDuplicate:
                i = j
                if j == n - 1:
                    break
            else:
                return i
        if i == n - 1:
            return -1
        else:
            return i


# s = Solution()
# print(s.findValidSplit([4, 7, 8, 15, 3, 5]))
# print(s.findValidSplit([4, 7, 15, 8, 3, 5]))
# @lc code=end
