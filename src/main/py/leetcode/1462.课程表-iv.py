#
# @lc app=leetcode.cn id=1462 lang=python3
#
# [1462] 课程表 IV
#
# https://leetcode.cn/problems/course-schedule-iv/description/
#
# algorithms
# Medium (45.57%)
# Likes:    105
# Dislikes: 0
# Total Accepted:    12K
# Total Submissions: 26.2K
# Testcase Example:  '2\n[[1,0]]\n[[0,1],[1,0]]'
#
# 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中
# prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
#
#
# 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
#
#
# 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
#
# 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj
# 的先决条件。
#
# 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
#
#
#
# 示例 1：
#
#
#
#
# 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
# 输出：[false,true]
# 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
#
#
# 示例 2：
#
#
# 输入：numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
# 输出：[false,false]
# 解释：没有先修课程对，所以每门课程之间是独立的。
#
#
# 示例 3：
#
#
#
#
# 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries =
# [[1,0],[1,2]]
# 输出：[true,true]
#
#
#
#
# 提示：
#
#
#
#
# 2 <= numCourses <= 100
# 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
# prerequisites[i].length == 2
# 0 <= ai, bi <= n - 1
# ai != bi
# 每一对 [ai, bi] 都 不同
# 先修课程图中没有环。
# 0 <= ui, vi <= n - 1
# ui != vi
#
#
#

# @lc code=start
from typing import List


class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        inDegree = [0] * numCourses
        graph = [List[int]] * numCourses
        allQueries = [List[bool]] * numCourses
        for i in range(numCourses):
            graph[i] = []
            allQueries[i] = [False] * numCourses

        for pre in prerequisites:
            inDegree[pre[1]] += 1
            graph[pre[0]].append(pre[1])

        queue = []
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)

        while len(queue) > 0:
            ind = queue.pop(0)
            for q in graph[ind]:
                inDegree[q] -= 1
                if inDegree[q] == 0:
                    queue.append(q)
                for j in range(numCourses):
                    if allQueries[q][j]:
                        continue
                    allQueries[q][j] = allQueries[ind][j]
                allQueries[q][ind] = True
        m = len(queries)
        res = [False] * m
        for i in range(m):
            res[i] = allQueries[queries[i][1]][queries[i][0]]
        return res


# s = Solution()
# numCourses, prerequisites, queries = 2, [[1, 0]], [[0, 1], [1, 0]]
# print(s.checkIfPrerequisite(numCourses, prerequisites, queries))

# numCourses, prerequisites, queries = 2, [], [[1, 0], [0, 1]]
# print(s.checkIfPrerequisite(numCourses, prerequisites, queries))

# numCourses, prerequisites, queries = 3, [
#     [1, 2], [1, 0], [2, 0]], [[1, 0], [1, 2]]
# print(s.checkIfPrerequisite(numCourses, prerequisites, queries))
# numCourses = 5
# prerequisites = [[0, 1], [1, 2], [2, 3], [3, 4]]
# queries = [[0, 4], [4, 0], [1, 3], [3, 0]]
# [true,false,true,false]
# print(s.checkIfPrerequisite(numCourses, prerequisites, queries))

# numCourses = 4
# prerequisites = [[2, 3], [2, 1], [0, 3], [0, 1]]
# queries = [[0, 1], [0, 3], [2, 3], [3, 0], [2, 0], [0, 2]]
# [true,true,true,false,false,false]
# print(s.checkIfPrerequisite(numCourses, prerequisites, queries))
# @lc code=end
