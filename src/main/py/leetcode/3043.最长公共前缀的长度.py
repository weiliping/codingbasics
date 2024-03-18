#
# @lc app=leetcode.cn id=3043 lang=python3
#
# [3043] 最长公共前缀的长度
#
# https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/
#
# algorithms
# Medium (38.70%)
# Likes:    5
# Dislikes: 0
# Total Accepted:    3.3K
# Total Submissions: 8.5K
# Testcase Example:  '[1,10,100]\n[1000]'
#
# 给你两个 正整数 数组 arr1 和 arr2 。
#
# 正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。
#
# 设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 ，而
# 1223 和 43456 没有 公共前缀。
#
# 你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。
#
# 返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。
#
#
#
# 示例 1：
#
#
# 输入：arr1 = [1,10,100], arr2 = [1000]
# 输出：3
# 解释：存在 3 个数对 (arr1[i], arr2[j]) ：
# - (1, 1000) 的最长公共前缀是 1 。
# - (10, 1000) 的最长公共前缀是 10 。
# - (100, 1000) 的最长公共前缀是 100 。
# 最长的公共前缀是 100 ，长度为 3 。
#
#
# 示例 2：
#
#
# 输入：arr1 = [1,2,3], arr2 = [4,4,4]
# 输出：0
# 解释：任何数对 (arr1[i], arr2[j]) 之中都不存在公共前缀，因此返回 0 。
# 请注意，同一个数组内元素之间的公共前缀不在考虑范围内。
#
#
#
#
# 提示：
#
#
# 1 <= arr1.length, arr2.length <= 5 * 10^4
# 1 <= arr1[i], arr2[i] <= 10^8
#
#
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        s = set()
        for v in arr1:
            while v > 0:
                s.add(str(v))
                v //= 10
        m = 0
        for v in arr2:
            while v > 0:
                k = str(v)
                if k in s and len(k) > m:
                    m = len(k)
                v //= 10
        return m

# @lc code=end

