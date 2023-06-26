#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumPasses' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. LONG_INTEGER m
#  2. LONG_INTEGER w
#  3. LONG_INTEGER p
#  4. LONG_INTEGER n
#


def minimumPasses(m, w, p, n):
    # Write your code here
    if n // m <= w - 1:
        return 1
    s = 0
    day = 0
    while s < n:
        cur = m * w
        if s + cur >= n:
            return day + 1
        l = n - s
        if l <= p:
            day += l // cur
            return day if l % cur == 0 else day + 1
        df = p - s
        nDays = df // cur
        if df % cur != 0:
            nDays += 1
        s += cur * nDays
        day += nDays

        tDiff = n - s
        cDay = tDiff // cur
        if tDiff % cur != 0:
            cDay += 1
        canPlus = s // p
        nextW, nextM = getNext(w, m, canPlus)
        nextV = nextW * nextM
        nt = n - s + p * canPlus
        nDays = nt // nextV
        if nt % nextV != 0:
            nDays += 1
        if cDay >= nDays:
            m = nextM
            w = nextW
            s -= p * canPlus
        else:
            return day + cDay
    return day


def getNext(w, m, canPlus):
    nextW, nextM = w, m
    if abs(nextW - nextM) >= canPlus:
        if nextM > nextW:
            return (nextW + canPlus, nextM)
        return (nextW, nextM + canPlus)
    t = nextW + nextM + canPlus
    nextM = t >> 1
    nextW = nextM + 1 if t & 1 == 1 else nextM
    return (nextW, nextM)


# print(minimumPasses(5184889632, 5184889632, 20, 10000))
print(minimumPasses(1, 1, 6, 45))
# print(minimumPasses(3, 1, 2, 12))


# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     m = int(first_multiple_input[0])

#     w = int(first_multiple_input[1])

#     p = int(first_multiple_input[2])

#     n = int(first_multiple_input[3])

#     result = minimumPasses(m, w, p, n)

#     fptr.write(str(result) + '\n')

#     fptr.close()
