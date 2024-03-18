#
# @lc app=leetcode.cn id=3039 lang=python3
#
# [3039] 进行操作使字符串为空
#
# https://leetcode.cn/problems/apply-operations-to-make-string-empty/description/
#
# algorithms
# Medium (64.75%)
# Likes:    4
# Dislikes: 0
# Total Accepted:    2.7K
# Total Submissions: 4.2K
# Testcase Example:  '"aabcbbca"'
#
# 给你一个字符串 s 。
#
# 请你进行以下操作直到 s 为 空 ：
#
#
# 每次操作 依次 遍历 'a' 到 'z'，如果当前字符出现在 s 中，那么删除出现位置 最早 的该字符（如果存在的话）。
#
#
# 例如，最初 s = "aabcbbca"。我们执行下述操作：
#
#
# 移除下划线的字符  s = "aabcbbca"。结果字符串为 s = "abbca"。
# 移除下划线的字符  s = "abbca"。结果字符串为 s = "ba"。
# 移除下划线的字符  s = "ba"。结果字符串为 s = ""。
#
#
# 请你返回进行 最后 一次操作 之前 的字符串 s 。在上面的例子中，答案是 "ba"。
#
#
#
# 示例 1：
#
#
# 输入：s = "aabcbbca"
# 输出："ba"
# 解释：已经在题目描述中解释。
#
#
# 示例 2：
#
#
# 输入：s = "abcd"
# 输出："abcd"
# 解释：我们进行以下操作：
# - 删除 s = "abcd" 中加粗加斜字符，得到字符串 s = "" 。
# 进行最后一次操作之前的字符串为 "abcd" 。
#
#
#
#
# 提示：
#
#
# 1 <= s.length <= 5 * 10^5
# s 只包含小写英文字母。
#
#
#

# @lc code=start
class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        mv, chs = 0, []
        chars = {}
        for c in s:
            chars[c] = chars.get(c, 0) + 1
            if mv < chars[c]:
                chs = [c]
                mv = chars[c]
            elif mv == chars[c]:
                chs.append(c)
        return "".join(chs)
# s = Solution()
# print(s.lastNonEmptyString("abcd"))
# @lc code=end

