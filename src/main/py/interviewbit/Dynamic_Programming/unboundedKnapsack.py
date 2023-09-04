#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'unboundedKnapsack' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY arr
#


def unboundedKnapsack(k, arr):
    # Write your code here
    dp = [False for _ in range(k + 1)]
    dp[0] = True
    for a in arr:
        for i in range(a, k + 1):
            dp[i] |= dp[i - a]
    for j in range(k, -1, -1):
        if dp[j]:
            return j
    return 0


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    arr = list(map(int, input().rstrip().split()))

    result = unboundedKnapsack(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
