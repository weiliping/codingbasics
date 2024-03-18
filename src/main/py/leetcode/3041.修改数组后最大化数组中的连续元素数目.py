#
# @lc app=leetcode.cn id=3041 lang=python3
#
# [3041] 修改数组后最大化数组中的连续元素数目
#
# https://leetcode.cn/problems/maximize-consecutive-elements-in-an-array-after-modification/description/
#
# algorithms
# Hard (45.60%)
# Likes:    9
# Dislikes: 0
# Total Accepted:    2.1K
# Total Submissions: 4.6K
# Testcase Example:  '[2,1,5,1,1]'
#
# 给你一个下标从 0 开始只包含 正 整数的数组 nums 。
# 
# 一开始，你可以将数组中 任意数量 元素增加 至多 1 。
# 
# 修改后，你可以从最终数组中选择 一个或者更多 元素，并确保这些元素升序排序后是 连续 的。比方说，[3, 4, 5] 是连续的，但是 [3, 4, 6]
# 和 [1, 1, 2, 3] 不是连续的。
# 
# 请你返回 最多 可以选出的元素数目。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [2,1,5,1,1]
# 输出：3
# 解释：我们将下标 0 和 3 处的元素增加 1 ，得到结果数组 nums = [3,1,5,2,1] 。
# 我们选择元素 [3,1,5,2,1] 并将它们排序得到 [1,2,3] ，是连续元素。
# 最多可以得到 3 个连续元素。
# 
# 示例 2：
# 
# 
# 输入：nums = [1,4,7,10]
# 输出：1
# 解释：我们可以选择的最多元素数目是 1 。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 10^5
# 1 <= nums[i] <= 10^6
# 
# 
#

# @lc code=start
class Solution:
    def maxSelectedElements(self, nums: List[int]) -> int:
# @lc code=end

