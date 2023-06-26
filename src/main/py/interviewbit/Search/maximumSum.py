#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'maximumSum' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. LONG_INTEGER_ARRAY a
#  2. LONG_INTEGER m
#


def maximumSum(a, m):
    # Write your code here
    from bisect import bisect, insort
    n = len(a)
    preSum = 0
    sums = []
    maxim = 0

    for i in range(n):
        preSum = (preSum + a[i]) % m
        pos = bisect(sums, preSum)
        d = 0 if pos == i else sums[pos]
        maxim = max(maxim, (preSum + m - d) % m)
        insort(sums, preSum)
    return maxim


print(maximumSum([3, 3, 9, 9, 5], 7))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         first_multiple_input = input().rstrip().split()

#         n = int(first_multiple_input[0])

#         m = int(first_multiple_input[1])

#         a = list(map(int, input().rstrip().split()))

#         result = maximumSum(a, m)

#         fptr.write(str(result) + '\n')

#     fptr.close()
