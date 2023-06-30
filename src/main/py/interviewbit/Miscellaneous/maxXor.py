#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxXor function below.


class NumTree:
    def __init__(self, d):
        self.d = d
        self.l = None
        self.r = None


def maxXor(arr, queries):
    # solve here
    MAX_BIT = 30
    root = NumTree(0)

    def buildTree(arr):
        for num in arr:
            buildChild(root, num, MAX_BIT)

    def buildChild(root, num, i):
        if i == -1:
            return
        if ((num >> i) & 1) == 0:
            if not root.l:
                root.l = NumTree(0)
            buildChild(root.l, num, i - 1)
        else:
            if not root.r:
                root.r = NumTree(1 << i)
            buildChild(root.r, num, i - 1)
    buildTree(arr)

    def getVal(q, root, i, v):
        if not root:
            return
        if i == -1:
            return
        j = ((q >> i) & 1)

        if (j ^ 1) == 1:
            if root.r:
                v[0] += root.r.d
                getVal(q, root.r, i - 1, v)
            else:
                getVal(q, root.l, i - 1, v)
        else:
            if root.l:
                v[0] += (1 << i)
                getVal(q, root.l, i - 1, v)
            else:
                getVal(q, root.r, i - 1, v)
    maxRes = []
    for q in queries:
        maxV = [0]
        getVal(q, root, MAX_BIT, maxV)
        maxRes.append(maxV[0])
    return maxRes


print(maxXor([3, 7, 5, 10], [3]))
print(maxXor([5, 1, 7, 4, 3], [2, 0]))
print(maxXor([1, 3, 5, 7], [17, 6]))
# def reverseTree(root, ps):
#     if not root:
#         return
#     if not root.l and not root.r:
#         print(ps)
#     if root.l:
#         left = ps.copy()
#         left.append(0)
#         reverseTree(root.l, left)
#     if root.r:
#         right = ps.copy()
#         right.append(1)
#         reverseTree(root.r, right)

# reverseTree(root, [-1])
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input())

#     arr = list(map(int, input().rstrip().split()))

#     m = int(input())

#     queries = []

#     for _ in range(m):
#         queries_item = int(input())
#         queries.append(queries_item)

#     result = maxXor(arr, queries)

#     fptr.write('\n'.join(map(str, result)))
#     fptr.write('\n')

#     fptr.close()
