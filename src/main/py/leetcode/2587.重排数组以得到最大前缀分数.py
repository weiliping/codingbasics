#
# @lc app=leetcode.cn id=2587 lang=python3
#
# [2587] 重排数组以得到最大前缀分数
#

# @lc code=start
class Solution:
    def maxScore(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        prefixSum = []
        prefixSum.append(0)
        cnt = 0
        for i in range(len(nums)):
            prefixSum.append(prefixSum[-1]+nums[i])
            if (prefixSum[-1] <= 0):
                return cnt
            else:
                cnt += 1
        return cnt
# @lc code=end

