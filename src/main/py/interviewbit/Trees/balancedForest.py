#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'balancedForest' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY c
#  2. 2D_INTEGER_ARRAY edges
#


def balancedForest(c, edges):
    # Write your code here
    n = len(c)
    if n < 3:
        return -1
    from bisect import bisect
    MV = 10**14
    p, visited, parents, g = [], [], [], []
    for _ in range(n):
        p.append(0)
        visited.append(False)
        g.append([])
        parents.append([])

    for k in range(len(edges)):
        e = edges[k]
        ii, jj = e[0] - 1, e[1] - 1
        g[ii].append(jj)
        g[jj].append(ii)

    t = sum(c)
    minV = t // 3
    if t % 3 != 0:
        minV += 1
    maxV = t // 2
    s = {}

    def dfsHelper(i, p, visited, parents, g, c, minV, maxV, s, t):
        if p[i] != 0:
            return p[i]
        visited[i] = True
        v = c[i]
        parent = parents[i].copy()
        parent.append(i)
        for j in g[i]:
            if visited[j]:
                continue
            parents[j] = parent
            chV = dfsHelper(j, p, visited, parents, g, c, minV, maxV, s, t)
            if isAble(minV, maxV, chV, t):
                if chV not in s:
                    s[chV] = []
                s[chV].append(j)
            v += chV

        p[i] = v
        return p[i]

    def isAble(minV, maxV, v, t):
        if v < minV:
            leftV = t - v
            if leftV % 2 != 0:
                return False
            h = leftV >> 1
            if h > maxV or h < minV:
                return False
            return True
        if v >= minV and v <= maxV:
            return True
        if ((v << 1) - t) < minV:
            return True
        return False
    dfsHelper(0, p, visited, parents, g, c, minV, maxV, s, t)
    res = MV
    ks = sorted(s.keys())
    nI = bisect(ks, minV) - 1
    if ks[nI] < minV:
        nI += 1
    while nI < len(ks):
        k = ks[nI]
        dK = k << 1
        if dK <= t:
            leftK = t - dK
            if len(s[k]) == 2:
                res = min(res, k - leftK)
            else:
                if leftK == 0:
                    res = min(res, k - leftK)
                elif leftK != k and leftK in s:
                    for nodeJ in s[leftK]:
                        if s[k][0] not in parents[nodeJ]:
                            res = min(res, k - leftK)
                elif k + leftK in s:
                    for nodeJ in s[k + leftK]:
                        if nodeJ in parents[s[k][0]]:
                            res = min(res, k - leftK)
        else:
            h = t - k
            nodeI = s[k][0]
            leftK = k - h
            if leftK in s:
                for nodeJ in s[leftK]:
                    if nodeI in parents[nodeJ]:
                        res = min(res, h - leftK)
        nI += 1
    return -1 if res == MV else res


# f = open(os.path.dirname(os.path.abspath(__file__)) +
#          '/balanced_forest_params5.txt', 'r')
# dp = []
# c = []
# for a in f:
#     nums = a.strip().split(' ')
#     if len(nums) > 2:
#         for cNum in nums:
#             c.append(int(cNum))
#     else:
#         dp.append([int(nums[0]), int(nums[1])])
# print(balancedForest(c, dp))

# f = open(os.path.dirname(os.path.abspath(__file__)) +
#          '/balanced_forest_params.txt', 'r')
# dp1 = []
# c1 = []
# for a in f:
#     nums = a.strip().split(' ')
#     if len(nums) > 2:
#         for cNum in nums:
#             c1.append(int(cNum))
#     else:
#         dp1.append([int(nums[0]), int(nums[1])])
# print(balancedForest(c1, dp1))
# print(balancedForest([1], []))
# c, edges = [15, 12, 8, 14, 13], [[1, 2], [1, 3], [1, 4], [4, 5]]
# print(balancedForest(c, edges))
c1, edges1 = [1, 3, 5], [[1, 3], [1, 2]]
print(balancedForest(c1, edges1))
# c2, edges2 = [1, 2, 2, 1, 1], [[1, 2], [1, 3], [3, 5], [1, 4]]
# print(balancedForest(c2, edges2))


# c5, e5 = [7, 7, 4, 1, 1, 1], [[1, 2], [3, 1], [2, 4], [2, 5], [2, 6]]
# print(balancedForest(c5, e5))
# c6, e6 = [1, 1, 1, 18, 10, 11, 5, 6], [
#     [1, 2], [1, 4], [2, 3], [1, 8], [8, 7], [7, 6], [5, 7]]
# print(balancedForest(c6, e6))
# c7, e7 = [12, 7, 11, 17, 20, 10], [[1, 2], [2, 3], [4, 5], [6, 5], [1, 4]]
# print(balancedForest(c7, e7))
# c8, e8 = [10, 4, 1, 5, 6, 4, 5, 5], [
#     [1, 2], [2, 3], [1, 4], [5, 4], [5, 6], [7, 8], [7, 5]]
# print(balancedForest(c8, e8))
# c9, e9 = [100, 100, 99, 99, 98, 98], [[1, 3], [3, 5], [1, 2], [2, 4], [4, 6]]
# print(balancedForest(c9, e9))
# c10, e10 = [2, 3, 3, 4], [[1, 2], [1, 4], [2, 3]]
# print(balancedForest(c10, e10))
# c3, edges3 = [12, 10, 8, 12, 14, 12], [[1, 2], [1, 3], [1, 4], [2, 5], [4, 6]]
# print(balancedForest(c3, edges3))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         n = int(input().strip())

#         c = list(map(int, input().rstrip().split()))

#         edges = []

#         for _ in range(n - 1):
#             edges.append(list(map(int, input().rstrip().split())))

#         result = balancedForest(c, edges)

#         fptr.write(str(result) + '\n')

#     fptr.close()
