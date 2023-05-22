#
# @lc app=leetcode.cn id=2101 lang=python3
#
# [2101] 引爆最多的炸弹
#
# https://leetcode.cn/problems/detonate-the-maximum-bombs/description/
#
# algorithms
# Medium (39.58%)
# Likes:    35
# Dislikes: 0
# Total Accepted:    5.6K
# Total Submissions: 14K
# Testcase Example:  '[[2,1,3],[6,1,4]]'
#
# 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
#
# 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的
# X 和 Y 坐标，ri 表示爆炸范围的 半径 。
#
# 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
#
# 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
#
#
#
# 示例 1：
#
#
#
# 输入：bombs = [[2,1,3],[6,1,4]]
# 输出：2
# 解释：
# 上图展示了 2 个炸弹的位置和爆炸范围。
# 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
# 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
# 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
#
#
# 示例 2：
#
#
#
# 输入：bombs = [[1,1,5],[10,10,5]]
# 输出：1
# 解释：
# 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
#
#
# 示例 3：
#
#
#
# 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
# 输出：5
# 解释：
# 最佳引爆炸弹为炸弹 0 ，因为：
# - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
# - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
# - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
# 所以总共有 5 个炸弹被引爆。
#
#
#
#
# 提示：
#
#
# 1 <= bombs.length <= 100
# bombs[i].length == 3
# 1 <= xi, yi, ri <= 10^5
#
#
#

# @lc code=start
from typing import List
import heapq


class Solution:
    def arrayManipulationIII(self, n: int, queries: List[int]) -> int:
        queries.sort(key=lambda a: (a[0], a[1]))
        prevInd, prevVal, maxV = queries[0][0], queries[0][2], -1
        stack = [[queries[0][1], queries[0][2]]]
        i, m = 1, len(queries)

        while i < m:
            currItem = queries[i]
            if currItem[0] != prevInd:
                maxV = max(maxV, prevVal)
                while stack and stack[0][0] < currItem[0]:
                    prevVal -= heapq.heappop(stack)[1]
                prevInd = currItem[0]
                prevVal += currItem[2]
                heapq.heappush(stack, [currItem[1], currItem[2]])
                i += 1
            else:
                while i < m and queries[i][0] == prevInd:
                    prevVal += queries[i][2]
                    heapq.heappush(stack, [queries[i][1], queries[i][2]])
                    i += 1
        return max(maxV, prevVal)

    def arrayManipulationII(self, n: int, queries: List[int]) -> int:
        nums = []
        for q in queries:
            if q[0] not in nums:
                nums.append(q[0])
            if q[1] + 1 not in nums:
                nums.append(q[1] + 1)
        nums.sort()
        sums = [0 for i in range(len(nums)+1)]

        for q in queries:
            iS = self.bsFirstLess(nums, q[0])
            iE = self.bsFirstGreat(nums, q[1])
            for i in range(iS + 1, iE, 1):
                sums[i] += q[2]
        return max(sums)

    def bsFirstLess(self, nums: List[int], v: int) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = l + ((r - l) >> 1)
            if nums[mid] >= v:
                if mid == 0 or nums[mid - 1] < v:
                    return mid - 1
                else:
                    r = mid - 1
            else:
                if mid == n or nums[mid + 1] >= v:
                    return mid
                else:
                    l = mid + 1
        return -1

    def bsFirstGreat(self, nums: List[int], v: int) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = l + ((r - l) >> 1)
            if nums[mid] > v:
                if mid == 0 or nums[mid - 1] <= v:
                    return mid
                else:
                    r = mid - 1
            else:
                if mid == n:
                    return mid
                elif nums[mid + 1] > v:
                    return mid + 1
                else:
                    l = mid + 1
        return -1

    def arrayManipulation(self, n: int, queries: List[int]) -> int:
        queries.sort(key=lambda a: (a[0], -a[1]))
        m, stack, i = len(queries), [], 1
        maxV = queries[0][2]
        stack.append(queries[0])
        while i < m:
            curr = queries[i]
            j, stack2 = i + 1, []
            stack2.append(curr)
            while j < m and queries[j][0] == curr[0]:
                prev = stack2.pop(-1)
                nextQ = queries[j]
                if prev[1] > nextQ[1]:
                    stack2.append([nextQ[1] + 1, prev[1], prev[2]])
                stack2.append([nextQ[0], nextQ[1], nextQ[2] + prev[2]])
                j += 1
            while len(stack2) > 0:
                currItem = stack2.pop(-1)
                currStack = []
                while len(stack) > 0 and stack[-1][1] >= currItem[0]:
                    currStack.append(stack.pop(-1))
                while len(currStack) > 0:
                    prevItem = currStack.pop(-1)
                    if prevItem[1] >= currItem[0] or prevItem[0] <= currItem[1]:
                        next = currItem[0]
                        if prevItem[0] < currItem[0]:
                            stack.append(
                                [prevItem[0], currItem[0] - 1, prevItem[2]])
                        elif prevItem[0] > currItem[0]:
                            next = prevItem[0]
                            stack.append(
                                [currItem[0], prevItem[0] - 1, currItem[2]])

                        v = prevItem[2] + currItem[2]
                        maxV = max(maxV, v)
                        if prevItem[1] <= currItem[1]:
                            stack.append([next, prevItem[1], v])
                            if prevItem[1] < currItem[1]:
                                currItem = [prevItem[1] + 1,
                                            currItem[1], currItem[2]]
                        elif currItem[1] != -1:
                            stack.append([next, currItem[1], v])
                            stack.append([currItem[1] + 1,
                                          prevItem[1], prevItem[2]])
                            currItem = [n + 1, -1, 0]
                    elif currItem[1] < prevItem[0] and currItem[1] != -1:
                        maxV = max(maxV, currItem[2])
                        stack.append(currItem)
                        stack.append(prevItem)
                        currItem = [n + 1, -1, 0]

                if currItem[1] != -1:
                    maxV = max(maxV, currItem[2])
                    stack.append(currItem)
                    currItem = [n + 1, -1, 0]
            i = j
        return maxV

    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        n = len(bombs)
        graph = [[] for i in range(n)]

        for i in range(n):
            cur = bombs[i]
            for j in range(i + 1, n):
                dis = (cur[0] - bombs[j][0]) ** 2 + (cur[1] - bombs[j][1]) ** 2
                if dis <= cur[2] ** 2:
                    graph[i].append(j)
                if dis <= bombs[j][2] ** 2:
                    graph[j].append(i)
        cnt = 0
        for i in range(n):
            visited = [False] * n
            self.dfsHelper(graph, visited, i)
            cnt = max(cnt, visited.count(True))
        return cnt

    def dfsHelper(self, graph: List[List[int]], visited: List[bool], ind: int):
        if visited[ind]:
            return
        visited[ind] = True
        for j in graph[ind]:
            self.dfsHelper(graph, visited, j)


s = Solution()
# print(s.arrayManipulationII(
#     40, [[1, 38, 892], [3, 39, 107], [3, 32, 11], [3, 26, 640], [3, 10, 905]]))
# print(s.arrayManipulation(40, [[1, 38, 892], [3, 39, 107], [3, 32, 11], [3, 26, 640], [3, 10, 905], [4, 24, 531], [5, 25, 29], [5, 22, 300], [8, 39, 483], [8, 22, 719], [8, 11, 194], [9, 26, 219], [9, 20, 20], [11, 31, 969], [
#     11, 30, 832], [11, 24, 83], [12, 37, 131], [12, 37, 502], [12, 18, 825], [14, 22, 321], [15, 23, 102], [15, 22, 335], [16, 24, 577], [21, 31, 214], [25, 32, 99], [29, 40, 787], [29, 35, 254], [29, 35, 267], [30, 38, 564], [33, 34, 351]]))
print(s.arrayManipulationII(40, [[1, 38, 892], [3, 39, 107], [3, 32, 11], [3, 26, 640], [3, 10, 905], [4, 24, 531], [5, 25, 29], [5, 22, 300], [8, 39, 483], [8, 22, 719], [8, 11, 194], [9, 26, 219], [9, 20, 20], [11, 31, 969], [
    11, 30, 832], [11, 24, 83], [12, 37, 131], [12, 37, 502], [12, 18, 825], [14, 22, 321], [15, 23, 102], [15, 22, 335], [16, 24, 577], [21, 31, 214], [25, 32, 99], [29, 40, 787], [29, 35, 254], [29, 35, 267], [30, 38, 564], [33, 34, 351]]))
# print(s.arrayManipulationIII(40, [[1, 38, 892], [3, 39, 107], [3, 32, 11], [3, 26, 640], [3, 10, 905], [4, 24, 531], [5, 25, 29], [5, 22, 300], [8, 39, 483], [8, 22, 719], [8, 11, 194], [9, 26, 219], [9, 20, 20], [11, 31, 969], [
#     11, 30, 832], [11, 24, 83], [12, 37, 131], [12, 37, 502], [12, 18, 825], [14, 22, 321], [15, 23, 102], [15, 22, 335], [16, 24, 577], [21, 31, 214], [25, 32, 99], [29, 40, 787], [29, 35, 254], [29, 35, 267], [30, 38, 564], [33, 34, 351]]))
# 8628
# print(s.arrayManipulation(
#     10, [[2, 6, 8], [3, 5, 7], [1, 8, 1], [5, 9, 15]]))  # 31
# print(s.arrayManipulationII(
#     10, [[2, 6, 8], [3, 5, 7], [1, 8, 1], [5, 9, 15]]))  # 31
print(s.arrayManipulationIII(
    10, [[2, 6, 8], [3, 5, 7], [1, 8, 1], [5, 9, 15]]))  # 31
# print(s.maximumDetonation([[2, 1, 3], [6, 1, 4]]))
# print(s.maximumDetonation([[1, 1, 5], [10, 10, 5]]))
# print(s.maximumDetonation(
#     [[1, 2, 3], [2, 3, 1], [3, 4, 2], [4, 5, 3], [5, 6, 4]]))

# print(s.maximumDetonation([[56, 80, 2], [55, 9, 10], [32, 75, 2], [87, 89, 1], [61, 94, 3], [43, 82, 9], [
#       17, 100, 6], [50, 6, 7], [9, 66, 7], [98, 3, 6], [67, 50, 2], [79, 39, 5], [92, 60, 10], [49, 9, 9], [42, 32, 10]]))
# @lc code=end
