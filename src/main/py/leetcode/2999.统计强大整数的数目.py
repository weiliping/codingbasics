#
# @lc app=leetcode.cn id=2999 lang=python3
#
# [2999] 统计强大整数的数目
#

# @lc code=start
class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        s_int = int(s)
        cnt = 0 
        s_c, s_v = 0, s_int
        while s_v > 0:
            s_c += 1
            s_v //= 10

        def count(y: int, s_c: int, s_int: int, limit: int):
            ans, e_v = 0, limit + 1
            for i in range(15, s_c-1, -1):
                v = 10**i
                d = y//v
                y %= v
                if d > limit:
                    return ans + pow(e_v, i - s_c + 1)
                else:
                    ans += d * pow(e_v, i - s_c)
            return ans if y < s_int else ans + 1
        
        return count(finish, s_c, s_int, limit) - count(start - 1, s_c, s_int, limit)
# s = Solution()
# print(s.numberOfPowerfulInt(1829505, 1255574165, 7, "11223"))
# @lc code=end

