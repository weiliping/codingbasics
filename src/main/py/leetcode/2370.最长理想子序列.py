#
# @lc app=leetcode.cn id=2370 lang=python3
#
# [2370] 最长理想子序列
#
# https://leetcode.cn/problems/longest-ideal-subsequence/description/
#
# algorithms
# Medium (43.00%)
# Likes:    35
# Dislikes: 0
# Total Accepted:    8.2K
# Total Submissions: 19K
# Testcase Example:  '"acfgbd"\n2'
#
# 给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
#
#
# t 是字符串 s 的一个子序列。
# t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
#
#
# 返回 最长 理想字符串的长度。
#
# 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。
#
# 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。
#
#
#
# 示例 1：
#
#
# 输入：s = "acfgbd", k = 2
# 输出：4
# 解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
# 注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。
#
# 示例 2：
#
#
# 输入：s = "abcd", k = 3
# 输出：4
# 解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
#
#
#
#
# 提示：
#
#
# 1 <= s.length <= 10^5
# 0 <= k <= 25
# s 由小写英文字母组成
#
#
#

# @lc code=start
class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        n = len(s)
        dp = [[0]*26] * (n + 1)
        for i in range(1, n + 1, 1):
            chrInd = ord(s[i - 1]) - 97
            max = -1
            for j in range(26):
                dp[i][j] = dp[i - 1][j]
                if abs(j - chrInd) <= k:
                    if max < dp[i][j]:
                        max = dp[i][j]
            dp[i][chrInd] = max + 1

        cnt = 1
        for j in range(26):
            if cnt < dp[n][j]:
                cnt = dp[n][j]
        return cnt


# s = Solution()
# print(s.longestIdealString('acfgbd', 2))
# print(s.longestIdealString('abcd', 3))
# @lc code=end
