#
# @lc app=leetcode.cn id=3031 lang=python3
#
# [3031] 将单词恢复初始状态所需的最短时间 II
#
# https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-ii/description/
#
# algorithms
# Hard (39.34%)
# Likes:    8
# Dislikes: 0
# Total Accepted:    3.3K
# Total Submissions: 8.3K
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
# 1 <= word.length <= 10^6
# 1 <= k <= word.length
# word仅由小写英文字母组成。
#
#
#

# @lc code=start
class Solution:
    def minimumTimeToInitialState(self, word: str, k: int) -> int:
        MOD = 10**9 + 7
        SCALE_NUM = 31
        def hash_str(word: str, s: int, e: int) -> int:
            hash_v, i = 0, s
            while i < e:
                hash_v = hash_v * SCALE_NUM + ord(word[i])
                if hash_v > MOD:
                    hash_v %= MOD
                i += 1
            return hash_v

        n = len(word)
        l = n // k
        left_len = n - l * k
        left_hash = -1
        if left_len != 0:
            left_hash = hash_str(word, l * k, n)

        vs = [0] * l
        vs[0] = hash_str(word, 0, k)
        st_inds = []
        for i in range(1, l):
            s_ind = i * k
            vs[i] = hash_str(word, s_ind, s_ind + k)
            if vs[i] == vs[0]:
                st_inds.append(i)
        if st_inds:
            for _, j in enumerate(st_inds):
                i, e_ind = 1, j + 1
                while e_ind < l and vs[i] == vs[e_ind]:
                    i += 1
                    e_ind += 1
                if e_ind == l:
                    if left_hash != -1:
                        start_l = i * k
                        l_hash = hash_str(word, start_l, start_l + left_len)
                        if l_hash == left_hash:
                            return j
                        continue
                    return j
        if left_hash != -1:
            l_hash = hash_str(word, 0, left_len)
            if l_hash != left_hash:
                return l + 1
        return l
# @lc code=end

