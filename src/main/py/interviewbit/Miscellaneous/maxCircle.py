#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxCircle function below.


def maxCircle(queries):
    res, cnts, cnt = [], [], 2
    mp = dict()
    n = len(queries)
    for ind in range(n):
        p, q = queries[ind]
        i, j = mp.get(p, -1), mp.get(q, -1)
        if i == -1 and j == -1:
            nextInd = len(res)
            res.append(set(queries[ind]))
            mp[p] = nextInd
            mp[q] = nextInd
            cnts.append(cnt)
            continue
        if i == -1:
            s = res[j]
            mp[p] = j
            s.add(p)
            cnt = max(cnt, len(s))
            cnts.append(cnt)
            res[j] = s
            continue
        if j == -1:
            s = res[i]
            mp[q] = i
            s.add(q)
            cnt = max(cnt, len(s))
            cnts.append(cnt)
            res[i] = s
            continue
        if i == j:
            cnts.append(cnt)
            continue
        s1, s2 = res[i], res[j]
        if len(s1) < len(s2):
            s1, s2 = s2, s1
            i, j = j, i
        s1.update(s2)
        cnt = max(cnt, len(s1))
        cnts.append(cnt)
        for k in s2:
            mp[k] = i
    return cnts


def maxCircleII(queries):
    cnts, cnt = [], 0
    mp = dict()
    n = len(queries)
    for ind in range(n):
        i, j = queries[ind]
        if i not in mp:
            mp[i] = set([i])

        if j not in mp:
            mp[j] = set([j])

        s1, s2 = mp[i], mp[j]
        if s1 != s2:
            if len(s1) < len(s2):
                s1, s2 = s2, s1
            s1.update(s2)
            cnt = max(cnt, len(s1))
            for k in s2:
                mp[k] = s1

        cnts.append(cnt)
    return cnts


# 2, 2, 4, 4, 4, 7
print(maxCircle([[1, 2], [3, 4], [1, 3], [5, 7], [5, 6], [7, 4]]))
# 2, 2, 3, 3, 6, 6, 8, 8
print(maxCircle([[6, 4], [5, 9], [8, 5], [
      4, 1], [1, 5], [7, 2], [4, 2], [7, 6]]))
# f = open(os.path.dirname(os.path.abspath(__file__)) +
#          '/max_circle_params.txt', 'r')
# queries = []
# for a in f:
#     str = a.split(" ")
#     queries.append([int(str[0].strip()), int(str[1].strip())])
# print(maxCircle(queries))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input())

#     queries = []

#     for _ in range(q):
#         queries.append(list(map(int, input().rstrip().split())))

#     ans = maxCircle(queries)

#     fptr.write('\n'.join(map(str, ans)))
#     fptr.write('\n')

#     fptr.close()
