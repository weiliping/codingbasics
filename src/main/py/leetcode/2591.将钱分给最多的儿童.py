#
# @lc app=leetcode.cn id=2591 lang=python3
#
# [2591] 将钱分给最多的儿童
#

# @lc code=start
class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        money -= children
        rest = money % 7
        total = money // 7
        if rest == 0:
            return total if total <= children else children - 1
        else:
            if rest == 3 and total == children - 1:
                return total - 1
            else:
                if total < children:
                    return total
                else:
                    return children - 1


# s = Solution()
# print(s.distMoney(1, 9))
# print(s.distMoney(9, 9))
# @lc code=end
