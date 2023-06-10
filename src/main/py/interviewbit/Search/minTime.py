#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minTime function below.


def minTime(machines, goal):
    import heapq
    dp = {}
    q = []
    for m in machines:
        v = dp.get(m, 0)
        if v == 0:
            heapq.heappush(q, m)
        dp[m] = v + 1
    i, j = 0, goal * q[0]

    while i < j:
        mid = i + ((j - i) >> 1)
        p = products(dp, q, mid)
        if p == goal:
            return mid
        elif p > goal:
            j = mid
        else:
            i = mid + 1
    return j


def products(dp, q, d):
    p = 0
    for i in q:
        p += (d // i) * dp[i]
    return p


# print(minTime([3, 2, 3, 5, 2, 3, 9, 11], 10))
print(minTime([1, 3, 4], 10))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     nGoal = input().split()

#     n = int(nGoal[0])

#     goal = int(nGoal[1])

#     machines = list(map(int, input().rstrip().split()))

#     ans = minTime(machines, goal)

#     fptr.write(str(ans) + '\n')

#     fptr.close()
