#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'longestIncreasingSubsequence' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#


def longestIncreasingSubsequence(arr):
    # Write your code here
    n = len(arr)
    dp = [0 for _ in range(n + 1)]
    dp[1] = arr[0]
    s = 1
    for i in range(1, n):
        if dp[s] < arr[i]:
            s += 1
            dp[s] = arr[i]
        else:
            l, r, pos = 1, s, 0
            while l <= r:
                mid = l + ((r - l) >> 1)
                if dp[mid] < arr[i]:
                    pos = mid
                    l = mid + 1
                else:
                    r = mid - 1
            dp[pos + 1] = arr[i]
    return s


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr_item = int(input().strip())
        arr.append(arr_item)

    result = longestIncreasingSubsequence(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
