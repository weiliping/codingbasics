#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'getWays' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. LONG_INTEGER_ARRAY c
#


def getWays(n, c):
    # Write your code here
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1
    m = len(c)
    c.sort()
    for j in range(m):
        for i in range(1, n + 1):
            if i >= c[j]:
                dp[i] += dp[i - c[j]]
    return dp[n]


arr = []
n = len(arr)
i, j = 0, 0
cntV, plusOne, minusOne = 0, 0, 0
res = 0
while j < n:
    if arr[j] == arr[i]:
        cntV += 1
        j += 1
        continue
    if arr[j] == arr[i] + 1:
        if minusOne == 0:
            plusOne += 1
            j += 1
            continue
        res = max(res, minusOne + cntV)
        pre = arr[i]
        while i < j:
            if pre == arr[i]:
                cntV -= 1
            else:
                minusOne -= 1
                if minusOne == 0:
                    break
            i += 1
        continue
    if arr[j] == arr[i] - 1:
        if plusOne == 0:
            minusOne += 1
            j += 1
            continue
        res = max(res, plusOne + cntV)
        pre = arr[i]
        while i < j:
            if pre == arr[i]:
                cntV -= 1
            else:
                plusOne -= 1
                if plusOne == 0:
                    break
            i += 1
        continue
    if plusOne != 0:
        res = max(res, plusOne + cntV)
    else:
        res = max(res, minusOne + cntV)
    i = j


print(getWays(3, [8, 3, 1, 2]))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     m = int(first_multiple_input[1])

#     c = list(map(int, input().rstrip().split()))

#     # Print the number of ways of making change for 'n' units using coins having the values given by 'c'

#     ways = getWays(n, c)

#     fptr.write(str(ways) + '\n')

#     fptr.close()
