from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n, max_v = len(nums), max(nums)
        i, j, s_cnt = 0, 0, 0
        cnt = 0
        while i < n:
            if max_v == nums[i]:
                s_cnt += 1
            while s_cnt >= k:
                cnt += (n - i)
                if max_v == nums[j]:
                    s_cnt -= 1
                j += 1
            i += 1
        return cnt


nums = [1, 3, 2, 3, 3]
k = 2
c = Solution()
print(c.countSubarrays(nums, k))
