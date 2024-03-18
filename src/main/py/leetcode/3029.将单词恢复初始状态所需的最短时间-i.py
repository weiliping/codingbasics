#
# @lc app=leetcode.cn id=3029 lang=python3
#
# [3029] 将单词恢复初始状态所需的最短时间 I
#
# https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-i/description/
#
# algorithms
# Medium (46.14%)
# Likes:    3
# Dislikes: 0
# Total Accepted:    3.3K
# Total Submissions: 7.2K
# Testcase Example:  '"abacaba"\n3'
#
# 给你一个下标从 0 开始的字符串 word 和一个整数 k 。
#
# 在每一秒，你必须执行以下操作：
#
#
# 移除 word 的前 k 个字符。
# 在 word 的末尾添加 k 个任意字符。
#
#
# 注意 添加的字符不必和移除的字符相同。但是，必须在每一秒钟都执行 两种 操作。
#
# 返回将 word 恢复到其 初始 状态所需的 最短 时间（该时间必须大于零）。
#
#
#
# 示例 1：
#
#
# 输入：word = "abacaba", k = 3
# 输出：2
# 解释：
# 第 1 秒，移除 word 的前缀 "aba"，并在末尾添加 "bac" 。因此，word 变为 "cababac"。
# 第 2 秒，移除 word 的前缀 "cab"，并在末尾添加 "aba" 。因此，word 变为 "abacaba" 并恢复到始状态。
# 可以证明，2 秒是 word 恢复到其初始状态所需的最短时间。
#
#
# 示例 2：
#
#
# 输入：word = "abacaba", k = 4
# 输出：1
# 解释：
# 第 1 秒，移除 word 的前缀 "abac"，并在末尾添加 "caba" 。因此，word 变为 "abacaba" 并恢复到初始状态。
# 可以证明，1 秒是 word 恢复到其初始状态所需的最短时间。
#
#
# 示例 3：
#
#
# 输入：word = "abcbabcd", k = 2
# 输出：4
# 解释：
# 每一秒，我们都移除 word 的前 2 个字符，并在 word 末尾添加相同的字符。
# 4 秒后，word 变为 "abcbabcd" 并恢复到初始状态。
# 可以证明，4 秒是 word 恢复到其初始状态所需的最短时间。
#
#
#
#
# 提示：
#
#
# 1 <= word.length <= 50
# 1 <= k <= word.length
# word仅由小写英文字母组成。
#
#
#

# @lc code=start
class Solution:
    def minimumTimeToInitialState(self, word: str, k: int) -> int:
        cnt = 1
        n = len(word)
        l = n // k
        if n % k != 0:
            l += 1
        while cnt < l:
            i, j = 0, cnt * k
            while j < n and word[i] == word[j]:
                i += 1
                j += 1
            if j == n:
                return cnt
            cnt += 1
        return cnt
# @lc code=end

