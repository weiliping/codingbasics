#
# @lc app=leetcode.cn id=2595 lang=python3
#
# [2595] 奇偶位数
#

# @lc code=start
class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        answer = [0, 0]
        i = 0
        while (i < 11):
            if (n >> i) & 1 == 1:
                if i & 1 == 0:
                    answer[0] += 1
                else:
                    answer[1] += 1
            i += 1
        return answer
# @lc code=end
